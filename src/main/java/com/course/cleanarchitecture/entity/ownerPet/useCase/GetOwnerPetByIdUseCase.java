package com.course.cleanarchitecture.entity.ownerPet.useCase;


import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.UUID;

public interface GetOwnerPetByIdUseCase {
    OwnerPetEntity execute(UUID id);
}
