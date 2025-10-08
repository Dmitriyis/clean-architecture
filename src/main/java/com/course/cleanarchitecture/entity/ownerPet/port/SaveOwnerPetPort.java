package com.course.cleanarchitecture.entity.ownerPet.port;


import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.UUID;

public interface SaveOwnerPetPort {
    UUID execute(OwnerPetEntity petEntity);
}
