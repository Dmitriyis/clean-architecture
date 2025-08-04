package com.course.cleanarchitecture.entity.pet.plugins.database.repository;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.provider.SavePetProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SavePetImpl implements SavePetProvider {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID execute(PetEntity petEntity) {
        return petRepositoryJpa.save(petEntity).getId();
    }
}
