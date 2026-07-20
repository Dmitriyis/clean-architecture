package com.course.cleanarchitecture.domain.ownerPet.core.ports;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;

import java.util.Optional;
import java.util.UUID;

public interface OwnerPetRepository {
    UUID save(OwnerPet ownerPet);

    Optional<OwnerPet> findById(UUID id);

    boolean isExists(UUID id);

    Optional<String> findOwnerPetPhoneByPetId(UUID id);
}
