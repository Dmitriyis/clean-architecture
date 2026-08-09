package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetNotificationSender;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.PetProviderForOwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.domain.ownerPet.exceptions.OwnerPetMedicalCardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SendNotificationsOwnerPetCommandHandlerImpl implements SendNotificationsOwnerPetCommandHandler {

    private final PetProviderForOwnerPet petProviderForOwnerPet;
    private final OwnerPetRepository ownerPetRepository;
    private final OwnerPetNotificationSender ownerPetNotificationSender;

    @Override
    @Transactional
    public void execute(SendNotificationsOwnerPetCommand command) {
        String messagePet = OwnerPetMedicalCardNotFoundException.prepareMessage("MedicalCard", "id", command.getPetId().toString());
        UUID ownerPetId = petProviderForOwnerPet.findOwnerPetIdByPetId(command.getPetId())
                .orElseThrow(() -> new OwnerPetMedicalCardNotFoundException(messagePet));

        String messageOwnerPet = OwnerPetNotFoundException.prepareMessage("OwnerPet", "id", ownerPetId.toString());
        String phone = ownerPetRepository.findOwnerPetPhoneByPetId(ownerPetId)
                .orElseThrow(() -> new OwnerPetNotFoundException(messageOwnerPet));

        ownerPetNotificationSender.send(command.getMessage(), phone);
    }
}
