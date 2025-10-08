package com.course.cleanarchitecture.entity.pet.application.port;

import java.util.UUID;

public interface DeletePetByIdPort {
    UUID execute(UUID id);
}
