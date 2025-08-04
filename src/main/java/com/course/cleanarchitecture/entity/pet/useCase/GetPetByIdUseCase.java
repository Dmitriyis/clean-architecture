package com.course.cleanarchitecture.entity.pet.useCase;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.util.UUID;

public interface GetPetByIdUseCase {
    PetEntity execute(UUID id);
}
