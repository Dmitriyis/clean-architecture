package com.course.cleanarchitecture.entity.ownerPet.useCase.provider;


import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.UUID;

public interface UpdateOwnerPetProvider {
    UUID execute(OwnerPetEntity petEntity);
}
