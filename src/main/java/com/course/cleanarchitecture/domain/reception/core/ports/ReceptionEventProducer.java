package com.course.cleanarchitecture.domain.reception.core.ports;

import com.course.cleanarchitecture.domain.reception.core.model.events.ReceptionCreateDomainEvent;

public interface ReceptionEventProducer {
    void publish(ReceptionCreateDomainEvent domainEvent) throws Exception;
}
