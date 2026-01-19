package com.course.cleanarchitecture.domain.reception.core.application.eventhandlers;

import com.course.cleanarchitecture.domain.reception.core.model.events.ReceptionCreateDomainEvent;
import com.course.cleanarchitecture.domain.reception.core.ports.ReceptionEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceptionCreateDomainEventHandler {

    private final ReceptionEventProducer receptionEventProducer;

    @EventListener
    public void handle(ReceptionCreateDomainEvent receptionCreateDomainEvent) throws Exception {
        receptionEventProducer.publish(receptionCreateDomainEvent);
    }
}
