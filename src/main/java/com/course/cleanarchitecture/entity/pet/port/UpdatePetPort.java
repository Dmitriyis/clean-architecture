package com.course.cleanarchitecture.entity.pet.port;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.util.UUID;

public interface UpdatePetPort {
    UUID execute(PetEntity petEntity);
}
