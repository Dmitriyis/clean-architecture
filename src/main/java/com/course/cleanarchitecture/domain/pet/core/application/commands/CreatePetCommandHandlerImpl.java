package com.course.cleanarchitecture.domain.pet.core.application.commands;

import com.course.cleanarchitecture.domain.pet.core.application.PetAppMapper;
import com.course.cleanarchitecture.domain.pet.core.model.MedicalCard;
import com.course.cleanarchitecture.domain.pet.core.model.Pet;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.shared.Age;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreatePetCommandHandlerImpl implements CreatePetCommandHandler {

    private final PetAppMapper petAppMapper;
    private final PetRepository petRepository;

    @Override
    @Transactional
    public UUID execute(CreatePetCommand command) {
        Age age = new Age(command.getAge());

        UUID petId = UUID.randomUUID();

        MedicalCard medicalCard = MedicalCard.create(
                UUID.randomUUID(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        Pet pet = Pet.create(
                petId,
                age,
                command.getName(),
                command.getWeight(),
                command.getOwnerPetId(),
                medicalCard,
                LocalDate.now()
        );

        return petRepository.save(pet);
    }
}
