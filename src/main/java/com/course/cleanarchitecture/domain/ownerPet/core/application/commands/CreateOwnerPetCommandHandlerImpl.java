package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOwnerPetCommandHandlerImpl implements CreateOwnerPetCommandHandler {

    private final OwnerPetRepository ownerPetRepository;

    @Override
    public UUID execute(CreateOwnerPetCommand command) {
        OwnerPet ownerPet = OwnerPet.createOwnerPet(
                UUID.randomUUID(),
                command.getName(),
                command.getPhone(),
                LocalDate.now(),
                command.getAddress()
        );

        return ownerPetRepository.save(ownerPet);
    }
}
