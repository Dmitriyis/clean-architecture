package com.course.cleanarchitecture.entity.ownerPet.useCase;

import java.util.UUID;

public interface DeleteOwnerPetByIdUseCase {
    UUID execute(UUID id);
}
