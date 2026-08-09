package com.course.cleanarchitecture.domain.ownerPet.core.ports;

import java.util.Optional;
import java.util.UUID;

public interface PetProviderForOwnerPet {
    Optional<UUID> findOwnerPetIdByPetId(UUID petId);
}
