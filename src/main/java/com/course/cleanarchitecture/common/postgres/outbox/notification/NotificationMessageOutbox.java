package com.course.cleanarchitecture.common.postgres.outbox.notification;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
//@Table(name = "message-domain-event-outbox")
public class NotificationMessageOutbox {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "payload", nullable = false)
    private String payload;

    @Column(name = "error_message", nullable = false)
    private String errorMessage;

    @Column(name = "processed_on_utc")
    private Instant processedOnUtc;

    public NotificationMessageOutbox(UUID id, String payload, String phone, String errorMessage) {
        this.id = ValidationValueUtils.againstNullOrEmpty(id, "id");
        this.payload = ValidationValueUtils.againstNullOrEmpty(payload, "payload");
        this.phone = ValidationValueUtils.againstNullOrEmpty(phone, "phone");
        this.phone = ValidationValueUtils.againstNullOrEmpty(errorMessage, "errorMessage");
    }

    public void markAsProcessed() {
        this.processedOnUtc = Instant.now();
    }
}
