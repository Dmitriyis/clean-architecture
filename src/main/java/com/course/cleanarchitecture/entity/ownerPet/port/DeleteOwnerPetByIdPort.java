package com.course.cleanarchitecture.entity.ownerPet.port;

import java.util.UUID;

public interface DeleteOwnerPetByIdPort {
    UUID execute(UUID id);
}
