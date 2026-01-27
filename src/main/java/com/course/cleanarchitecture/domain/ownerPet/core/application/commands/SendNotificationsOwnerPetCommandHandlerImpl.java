package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetNotificationSender;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SendNotificationsOwnerPetCommandHandlerImpl implements SendNotificationsOwnerPetCommandHandler {

    private final PetRepository petRepository;
    private final OwnerPetRepository ownerPetRepository;
    private final OwnerPetNotificationSender ownerPetNotificationSender;

    @Override
    @Transactional
    public void execute(SendNotificationsOwnerPetCommand sendNotificationsOwnerPetCommand) {
        UUID ownerPetId = petRepository.findByMedicalCardId(sendNotificationsOwnerPetCommand.getMedicalCardId()).getOwnerPetId();

        String phone = ownerPetRepository.findById(ownerPetId).getPhone();

        ownerPetNotificationSender.send("Оставьте отзыв о докторе.", phone);
    }
}
