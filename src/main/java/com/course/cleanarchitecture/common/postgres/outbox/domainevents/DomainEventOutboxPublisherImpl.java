package com.course.cleanarchitecture.common.postgres.outbox.domainevents;


import com.course.cleanarchitecture.domain.DomainEventPublisher;
import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.ddd.AggregateRoot;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DomainEventOutboxPublisherImpl implements DomainEventPublisher {

    private final DomainEventOutboxJpaRepository jpa;
    private final ObjectMapper objectMapper;

    @Override
    public void publish(Iterable<Aggregate<?>> aggregates) {
        try {
            for (AggregateRoot<?> aggregate : aggregates) {
                aggregate.getDomainEvents().forEach(domainEvent -> {
                    try {
                        var payload = objectMapper.writeValueAsString(domainEvent);

                        var outboxMessage = new MessageDomainEventOutbox(
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

//DomainEventPublisher.java
//        Порт принимает Aggregate — утечка доменной абстракции
//        void publish(Iterable<Aggregate<?>> aggregates) — порт принимает не события, а сами агрегаты. Use Case передаёт агрегаты в издатель,
//        который сам вытаскивает события. Это неправильная инверсия ответственности. Агрегат должен отдавать события (pullDomainEvents()),
//        use case их публиковать через порт EventPublisher.publishAll(List<DomainEvent>).