package com.course.cleanarchitecture.domain.pet.adapters.in.kafka;

import com.course.cleanarchitecture.domain.pet.core.application.commands.AddReceptionInMedicalCardCommand;
import com.course.cleanarchitecture.domain.pet.core.application.commands.AddReceptionInMedicalCardCommandHandler;
import com.course.cleanarchitecture.domain.reception.core.model.events.ReceptionCreateDomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceptionsEventsConsumer {

    private final ObjectMapper objectMapper;
    private final AddReceptionInMedicalCardCommandHandler addReceptionInMedicalCardCommandHandler;

    @KafkaListener(topics = "create-reception")
    public void updateMedicalCard(String message) {
        try {
            ReceptionCreateDomainEvent receptionCreateDomainEvent = objectMapper.readValue(message, ReceptionCreateDomainEvent.class);
            AddReceptionInMedicalCardCommand addReceptionInMedicalCardCommand = new AddReceptionInMedicalCardCommand(UUID.fromString(receptionCreateDomainEvent.getMedicalCardId()), UUID.fromString(receptionCreateDomainEvent.getReceptionId()));

            addReceptionInMedicalCardCommandHandler.execute(addReceptionInMedicalCardCommand);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to parse protobuf message", ex);
        }
    }
}
