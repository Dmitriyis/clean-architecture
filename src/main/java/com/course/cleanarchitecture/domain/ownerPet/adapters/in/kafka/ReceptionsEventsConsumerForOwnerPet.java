package com.course.cleanarchitecture.domain.ownerPet.adapters.in.kafka;//package com.course.cleanarchitecture.domain.pet.adapters.in.kafka;

import com.course.cleanarchitecture.domain.ownerPet.core.application.commands.SendNotificationsOwnerPetCommand;
import com.course.cleanarchitecture.domain.ownerPet.core.application.commands.SendNotificationsOwnerPetCommandHandler;
import com.course.cleanarchitecture.domain.reception.core.model.events.ReceptionCreateDomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceptionsEventsConsumerForOwnerPet {

    private final ObjectMapper objectMapper;
    private final SendNotificationsOwnerPetCommandHandler sendNotificationsOwnerPetCommandHandler;

    @KafkaListener(topics = "create-reception", groupId = "owner-pet")
    public void updateMedicalCard(String message) {
        try {
            ReceptionCreateDomainEvent receptionCreateDomainEvent = objectMapper.readValue(message, ReceptionCreateDomainEvent.class);
            SendNotificationsOwnerPetCommand sendNotificationsOwnerPetCommand = new SendNotificationsOwnerPetCommand(UUID.fromString(receptionCreateDomainEvent.getMedicalCardId()));
            sendNotificationsOwnerPetCommandHandler.execute(sendNotificationsOwnerPetCommand);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to parse protobuf message", ex);
        }
    }
}
