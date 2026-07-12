package com.course.cleanarchitecture.domain.ownerPet.adapters.out.notification;

import com.course.cleanarchitecture.common.postgres.outbox.failedNotification.FailedNotificationMessageJpaRepository;
import com.course.cleanarchitecture.common.postgres.outbox.failedNotification.FailedNotificationMessageOutbox;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetNotificationSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class JmsOwnerPetNotificationSenderImpl implements OwnerPetNotificationSender {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final FailedNotificationMessageJpaRepository failedNotificationMessageJpaRepository;

    @Value("${app.kafka.topic.ownerPetNotifications}")
    private String topicName;

    @Override
    public void send(String message, String phone) {
        log.info("Sending message to phone: {}", phone);
        kafkaTemplate.send(topicName, phone, message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Message sent successfully to topic {}.", topicName);
                    } else {
                        log.error("Failed to send message to Kafka", ex);

                        FailedNotificationMessageOutbox failedNotificationMessageOutbox = new FailedNotificationMessageOutbox(UUID.randomUUID(), message, phone, ex.getMessage());
                        failedNotificationMessageJpaRepository.save(failedNotificationMessageOutbox);
                    }
                });
    }
}
