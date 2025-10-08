package com.course.cleanarchitecture.entity.ownerPet.adapter.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.port.UpdateOwnerPetPort;
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
