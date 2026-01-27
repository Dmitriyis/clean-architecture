package com.course.cleanarchitecture.domain;


import com.course.cleanarchitecture.ddd.Aggregate;

public interface DomainEventPublisher {
    void publish(Iterable<Aggregate<?>> aggregates);
}
