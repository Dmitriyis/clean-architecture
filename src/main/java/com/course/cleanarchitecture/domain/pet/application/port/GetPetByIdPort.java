package com.course.cleanarchitecture.domain.pet.application.port;

import com.course.cleanarchitecture.domain.pet.model.PetEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetPetByIdPort {
    Optional<PetEntity> execute(UUID id);
}
