package com.course.cleanarchitecture.domain.ownerPet.adapters.in.kafka;

import com.course.cleanarchitecture.domain.ownerPet.adapters.in.kafka.eventsDto.ReceptionCreateDomainEventForOwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.core.application.commands.SendNotificationsOwnerPetCommand;
import com.course.cleanarchitecture.domain.ownerPet.core.application.commands.SendNotificationsOwnerPetCommandHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceptionCreateEventsConsumerForOwnerPet {

    private final ObjectMapper objectMapper;
    private final SendNotificationsOwnerPetCommandHandler sendNotificationsOwnerPetCommandHandler;
    // TODO доработать DLQ топик.
    @KafkaListener(topics = "reception-create", groupId = "owner-pet")
    public void createReception(String message, Acknowledgment acknowledgment) {
        try {
            ReceptionCreateDomainEventForOwnerPet receptionCreateDomainEventForOwnerPet = objectMapper.readValue(message, ReceptionCreateDomainEventForOwnerPet.class);

            UUID petId = UUID.fromString(receptionCreateDomainEventForOwnerPet.petId());

            SendNotificationsOwnerPetCommand sendNotificationsOwnerPetCommand = new SendNotificationsOwnerPetCommand(petId, "Оставьте отзыв после приема.");
            sendNotificationsOwnerPetCommandHandler.execute(sendNotificationsOwnerPetCommand);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to parse protobuf message", ex);
        }
    }
}
