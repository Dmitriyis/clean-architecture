package com.course.cleanarchitecture.domain.ownerPet.application.port;


import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetOwnerPetByIdPort {
    Optional<OwnerPetEntity> execute(UUID id);
}
