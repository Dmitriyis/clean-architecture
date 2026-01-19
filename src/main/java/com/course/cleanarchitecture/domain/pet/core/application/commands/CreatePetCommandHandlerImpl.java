package com.course.cleanarchitecture.domain.pet.core.application.commands;

import com.course.cleanarchitecture.domain.karnel.Age;
import com.course.cleanarchitecture.domain.pet.core.model.MedicalCard;
import com.course.cleanarchitecture.domain.pet.core.model.Pet;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreatePetCommandHandlerImpl implements CreatePetCommandHandler {

    private final PetRepository petRepository;

    @Override
    @Transactional
    public UUID execute(CreatePetCommand createPetCommand) {
        Age age = new Age(createPetCommand.getAge());
        MedicalCard medicalCard = new MedicalCard(UUID.randomUUID(), LocalDateTime.now(), null, null);

        Pet pet = new Pet(UUID.randomUUID(), age, createPetCommand.getName(), createPetCommand.getWeight(), createPetCommand.getOwnerPetId(), medicalCard, LocalDate.now());

        return petRepository.save(pet);
    }
}
