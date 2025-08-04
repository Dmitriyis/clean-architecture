package com.course.cleanarchitecture.entity.ownerPet.plugins.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.SaveOwnerPetProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SaveOwnerPetImpl implements SaveOwnerPetProvider {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public UUID execute(OwnerPetEntity petEntity) {
        return ownerPetRepositoryJpa.save(petEntity).getId();
    }
}
