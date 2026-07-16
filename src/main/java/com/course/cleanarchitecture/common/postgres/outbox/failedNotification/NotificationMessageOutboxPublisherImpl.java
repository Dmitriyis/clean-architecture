package com.course.cleanarchitecture.common.postgres.outbox.failedNotification;

import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.domain.DomainEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationMessageOutboxPublisherImpl implements DomainEventPublisher {
    @Override
    public void publish(Iterable<Aggregate<?>> aggregates) {

    }
}
