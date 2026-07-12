package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetNotificationSender;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import com.course.cleanarchitecture.domain.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.pet.exceptions.MedicalCardNotFoundException;
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
    public void execute(SendNotificationsOwnerPetCommand command) {
        String messagePet = MedicalCardNotFoundException.prepareMessage("MedicalCard", "id", command.getMedicalCardId().toString());
        UUID ownerPetId = petRepository.findOwnerPetIdByMedicalCardId(command.getMedicalCardId())
                .orElseThrow(() -> new MedicalCardNotFoundException(messagePet));

        String messageOwnerPet = OwnerPetNotFoundException.prepareMessage("OwnerPet", "id", ownerPetId.toString());
        String phone = ownerPetRepository.findOwnerPetPhoneByPetId(ownerPetId)
                .orElseThrow(() -> new OwnerPetNotFoundException(messageOwnerPet));

        ownerPetNotificationSender.send(command.getMessage(), phone);
    }
}
