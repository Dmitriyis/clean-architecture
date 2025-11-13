package com.course.cleanarchitecture.domain.ownerPet.application.port;


import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;

import java.util.UUID;

public interface SaveOwnerPetPort {
    UUID execute(OwnerPetEntity petEntity);
}
