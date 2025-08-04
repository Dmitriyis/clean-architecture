package com.course.cleanarchitecture.entity.pet.useCase.provider;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetPetByIdProvider {
    Optional<PetEntity> execute(UUID id);
}
