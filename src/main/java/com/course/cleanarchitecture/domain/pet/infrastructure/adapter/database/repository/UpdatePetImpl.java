package com.course.cleanarchitecture.domain.pet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import com.course.cleanarchitecture.domain.pet.application.port.UpdatePetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UpdatePetImpl implements UpdatePetPort {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID execute(PetEntity petEntity) {
        return petRepositoryJpa.save(petEntity).getId();
    }
}
