package com.course.cleanarchitecture.entity.ownerPet.application.port;


import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.UUID;

public interface UpdateOwnerPetPort {
    UUID execute(OwnerPetEntity petEntity);
}
