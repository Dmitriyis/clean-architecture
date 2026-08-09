package com.course.cleanarchitecture.ddd;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {

    private final UUID eventId;
    private final String action;
    private final Instant occurredOnUtc;

    protected DomainEvent(String action) {
        this.action = action;
        this.eventId = UUID.randomUUID();
        this.occurredOnUtc = Instant.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public Instant getOccurredOnUtc() {
        return occurredOnUtc;
    }

    public String getAction() {
        return action;
    }
}

