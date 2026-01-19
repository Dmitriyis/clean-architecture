package com.course.cleanarchitecture.domain;


import com.course.cleanarchitecture.ddd.Aggregate;

public interface DomainEventPublisher {
    public void publish(Iterable<Aggregate<?>> aggregates);
}
