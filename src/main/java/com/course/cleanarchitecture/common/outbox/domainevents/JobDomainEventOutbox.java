package com.course.cleanarchitecture.common.outbox.domainevents;

import com.course.cleanarchitecture.ddd.DomainEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RequiredArgsConstructor
public class JobDomainEventOutbox {

    private static final int MAX_RETRIES = 3;
    private static final String TEMPLATE_TOPIC_NAME = "%s-%s";

    private final DomainEventOutboxJpaRepository jpa;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedDelay = 1000)
    public void run() {
        List<DomainEventOutbox> domainEventsOutbox = jpa.findUnprocessedMessages();
        for (DomainEventOutbox domainEventOutbox : domainEventsOutbox) {
            try {

                String eventClassName = domainEventOutbox.getEventType();
                Class<?> eventClass = Class.forName(eventClassName);

                if (!DomainEvent.class.isAssignableFrom(eventClass)) {
                    throw new IllegalStateException("Invalid outbox message type: " + eventClass);
                }

                String payload = domainEventOutbox.getPayload();
                JsonNode jsonNode = objectMapper.readTree(payload);
                String action = jsonNode.get("action").asText();

                String topicName = String.format(TEMPLATE_TOPIC_NAME, domainEventOutbox.getAggregateType().toLowerCase(), action);

                kafkaTemplate.send(
                        topicName,
                        domainEventOutbox.getAggregateId(),
                        payload
                ).get(3, TimeUnit.SECONDS);

                domainEventOutbox.markAsProcessed();

                jpa.save(domainEventOutbox);
            } catch (ClassNotFoundException | IllegalArgumentException e) {

                log.debug("Fatal error for outbox id={}: {}", domainEventOutbox.getId(), e.getMessage());
                markAsFailed(domainEventOutbox, "Fatal error: " + e.getMessage());

            } catch (Exception e) {
                int currentRetryCount = domainEventOutbox.getRetryCount() == null ? 0 : domainEventOutbox.getRetryCount();
                int nextRetries = currentRetryCount + 1;

                log.debug("Failed to send outbox id={}. Retry attempt {}/{}", domainEventOutbox.getId(), nextRetries, MAX_RETRIES);

                domainEventOutbox.setRetryCount(nextRetries);
                domainEventOutbox.setErrorMessage(e.getMessage());

                if (nextRetries >= MAX_RETRIES) {
                    markAsFailed(domainEventOutbox, "Max retries reached. Error: " + e.getMessage());
                } else {
                    jpa.save(domainEventOutbox);
                }
            }
        }
    }

    private void markAsFailed(DomainEventOutbox domainEventOutbox, String errorMessage) {
        domainEventOutbox.setStatus("FAILED");
        domainEventOutbox.setErrorMessage(errorMessage);
        jpa.save(domainEventOutbox);

        log.debug("Outbox message id={} PERMANENTLY FAILED and moved to DLQ status in DB!", domainEventOutbox.getId());
    }
}
