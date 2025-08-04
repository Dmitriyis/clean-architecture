package com.course.cleanarchitecture.entity.pet.useCase.provider;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.util.UUID;

public interface UpdatePetProvider {
    UUID execute(PetEntity petEntity);
}
