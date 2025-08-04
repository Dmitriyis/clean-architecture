package com.course.cleanarchitecture.entity.ownerPet.useCase.provider;

import java.util.UUID;

public interface DeleteOwnerPetByIdProvider {
    UUID execute(UUID id);
}
