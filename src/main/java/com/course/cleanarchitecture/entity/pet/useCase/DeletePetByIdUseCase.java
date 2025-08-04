package com.course.cleanarchitecture.entity.pet.useCase;

import java.util.UUID;

public interface DeletePetByIdUseCase {
    UUID execute(UUID id);
}
