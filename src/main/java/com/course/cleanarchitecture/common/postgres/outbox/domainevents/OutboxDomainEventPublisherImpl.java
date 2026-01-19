package com.course.cleanarchitecture.common.postgres.outbox.domainevents;


import com.course.cleanarchitecture.domain.DomainEventPublisher;
import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.ddd.AggregateRoot;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OutboxDomainEventPublisherImpl implements DomainEventPublisher {

    private final OutboxJpaRepository jpa;
    private final ObjectMapper objectMapper;

    @Override
    public void publish(Iterable<Aggregate<?>> aggregates) {
        try {
            for (AggregateRoot<?> aggregate : aggregates) {
                aggregate.getDomainEvents().forEach(domainEvent -> {
                    try {
                        var payload = objectMapper.writeValueAsString(domainEvent);

                        var outboxMessage = new OutboxMessage(
                                domainEvent.getEventId(),
                                domainEvent.getClass().getName(),
                                aggregate.getId().toString(),
                                aggregate.getClass().getSimpleName(),
                                payload,
                                domainEvent.getOccurredOnUtc());
                        jpa.save(outboxMessage);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to serialize domainEvent for Outbox", e);
                    }
                });

                aggregate.clearDomainEvents();
            }
        } catch (Exception e) {
            throw new RuntimeException("Persist events is failed", e);
        }
    }
}
