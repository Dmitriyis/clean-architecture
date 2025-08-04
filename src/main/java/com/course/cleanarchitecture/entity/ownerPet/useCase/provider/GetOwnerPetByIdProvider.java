package com.course.cleanarchitecture.entity.ownerPet.useCase.provider;


import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetOwnerPetByIdProvider {
    Optional<OwnerPetEntity> execute(UUID id);
}
