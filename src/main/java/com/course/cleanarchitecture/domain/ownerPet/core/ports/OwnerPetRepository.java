package com.course.cleanarchitecture.domain.ownerPet.core.ports;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;

import java.util.UUID;

public interface OwnerPetRepository {
    UUID save(OwnerPet ownerPet);

    OwnerPet findById(UUID id);
}
