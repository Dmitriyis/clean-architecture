package com.course.cleanarchitecture.common.postgres.outbox.domainevents;

import com.course.cleanarchitecture.ddd.DomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JobOutboxDomainEvent {

    private final DomainEventOutboxJpaRepository jpa;
    private final ObjectMapper objectMapper;
    private final ApplicationEventPublisher publisher;

    @Scheduled(fixedDelay = 1000)
    public void run() {
        List<MessageDomainEventOutbox> outboxMessages = jpa.findUnprocessedMessages();
        for (MessageDomainEventOutbox outboxMessage : outboxMessages) {
            try {

                String eventClassName = outboxMessage.getEventType();
                Class<?> eventClass = Class.forName(eventClassName);
                Object eventObject = objectMapper.readValue(outboxMessage.getPayload(), eventClass);

                if (!(eventObject instanceof DomainEvent domainEvent)) {
                    throw new IllegalStateException("Invalid outbox message type: " + eventClass);
                }

                publisher.publishEvent(domainEvent);

                outboxMessage.markAsProcessed();
                jpa.save(outboxMessage);
            } catch (Exception e) {
                System.err.println("Failed to publish outbox message: " + e.getMessage());
            }
        }
    }
}
