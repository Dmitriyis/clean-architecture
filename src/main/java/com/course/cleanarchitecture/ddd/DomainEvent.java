package com.course.cleanarchitecture.ddd;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {

    private final UUID eventId;
    private final Instant occurredOnUtc;

    protected DomainEvent() {
        this.eventId = UUID.randomUUID();
        this.occurredOnUtc = Instant.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public Instant getOccurredOnUtc() {
        return occurredOnUtc;
    }
}

