package com.course.cleanarchitecture.domain.pet.application.port;

import com.course.cleanarchitecture.domain.pet.model.PetEntity;

import java.util.UUID;

public interface UpdatePetPort {
    UUID execute(PetEntity petEntity);
}
