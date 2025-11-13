package com.course.cleanarchitecture.domain.ownerPet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.ownerPet.application.port.UpdateOwnerPetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UpdateOwnerPetImpl implements UpdateOwnerPetPort {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public UUID execute(OwnerPetEntity petEntity) {
        return ownerPetRepositoryJpa.save(petEntity).getId();
    }
}
