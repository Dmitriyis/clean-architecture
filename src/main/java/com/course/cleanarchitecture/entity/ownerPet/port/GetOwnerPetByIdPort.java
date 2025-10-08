package com.course.cleanarchitecture.entity.ownerPet.port;


import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetOwnerPetByIdPort {
    Optional<OwnerPetEntity> execute(UUID id);
}
