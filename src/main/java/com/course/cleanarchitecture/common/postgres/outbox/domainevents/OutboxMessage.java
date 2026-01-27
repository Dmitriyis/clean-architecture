package com.course.cleanarchitecture.common.postgres.outbox.domainevents;



import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "outbox")
public class OutboxMessage {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "aggregate_id", nullable = false)
    private String aggregateId;

    @Column(name = "aggregate_type", nullable = false)
    private String aggregateType;

    @Column(name = "payload", nullable = false, columnDefinition = "text")
    private String payload;

    @Column(name = "occurred_on_utc", nullable = false)
    private Instant occurredOnUtc;

    @Column(name = "processed_on_utc")
    private Instant processedOnUtc;

    public OutboxMessage(UUID id, String eventType, String aggregateId, String aggregateType, String payload, Instant occurredOnUtc) {
        this.id = ValidationValueUtils.againstNullOrEmpty(id, "id");
        this.eventType = ValidationValueUtils.againstNullOrEmpty(eventType, "eventType");
        this.aggregateId = ValidationValueUtils.againstNullOrEmpty(aggregateId, "aggregateId");
        this.aggregateType = ValidationValueUtils.againstNullOrEmpty(aggregateType, "aggregateType");
        this.payload = ValidationValueUtils.againstNullOrEmpty(payload, "payload");
        this.occurredOnUtc = ValidationValueUtils.againstNull(occurredOnUtc, "occurredOnUtc");
    }

    public void markAsProcessed() {
        this.processedOnUtc = Instant.now();
    }
}
