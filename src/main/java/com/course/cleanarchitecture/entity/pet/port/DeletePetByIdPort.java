package com.course.cleanarchitecture.entity.pet.port;

import java.util.UUID;

public interface DeletePetByIdPort {
    UUID execute(UUID id);
}
