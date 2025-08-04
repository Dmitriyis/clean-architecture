package com.course.cleanarchitecture.entity.pet.useCase.provider;

import java.util.UUID;

public interface DeletePetByIdProvider {
    UUID execute(UUID id);
}
