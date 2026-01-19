package com.course.cleanarchitecture.domain.reception.adapters.out.kafka;

import com.course.cleanarchitecture.domain.reception.core.model.events.ReceptionCreateDomainEvent;
import com.course.cleanarchitecture.domain.reception.core.ports.ReceptionEventProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceptionEventProducerImpl implements ReceptionEventProducer {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publish(ReceptionCreateDomainEvent domainEvent) throws Exception {
        String value = objectMapper.writeValueAsString(domainEvent);

        kafkaTemplate.send("create-reception",domainEvent.getReceptionId(), value);
    }
}
