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
    public UUID execute(CreateOwnerPetCommand createOwnerPetCommand) {
        OwnerPet ownerPet = new OwnerPet(UUID.randomUUID(), createOwnerPetCommand.getName(), LocalDate.now(), createOwnerPetCommand.getAddress(), null);

        return ownerPetRepository.save(ownerPet);
    }
}
//CreatePetCommandHandlerImpl.java
//        Создание доменных объектов прямо в use case — нет Factory
//        Age age = new Age(...); MedicalCard medicalCard = new MedicalCard(UUID.randomUUID(), ...); Pet pet = new Pet(...) — сборка агрегата разбросана по use case.
//        Сложная логика создания должна быть в PetFactory. Use case должен вызывать petFactory.create(command).