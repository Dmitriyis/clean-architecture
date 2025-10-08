package com.course.cleanarchitecture.entity.pet.application.port;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetPetByIdPort {
    Optional<PetEntity> execute(UUID id);
}
