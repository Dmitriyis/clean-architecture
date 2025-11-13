package com.course.cleanarchitecture.domain.pet.application.port;

import java.util.UUID;

public interface DeletePetByIdPort {
    UUID execute(UUID id);
}
