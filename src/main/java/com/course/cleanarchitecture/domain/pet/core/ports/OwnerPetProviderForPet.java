package com.course.cleanarchitecture.domain.pet.core.ports;

import java.util.UUID;

public interface OwnerPetProviderForPet {
    boolean isOwnerPetExists(UUID ownerPetId);
}
