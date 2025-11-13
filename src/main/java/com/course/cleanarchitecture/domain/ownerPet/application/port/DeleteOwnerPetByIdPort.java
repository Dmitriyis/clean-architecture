package com.course.cleanarchitecture.domain.ownerPet.application.port;

import java.util.UUID;

public interface DeleteOwnerPetByIdPort {
    UUID execute(UUID id);
}
