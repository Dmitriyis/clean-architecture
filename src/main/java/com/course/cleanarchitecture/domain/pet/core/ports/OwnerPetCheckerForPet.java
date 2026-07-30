package com.course.cleanarchitecture.domain.pet.core.ports;

import java.util.UUID;

public interface OwnerPetCheckerForPet {
    boolean isOwnerPetExists(UUID ownerPetId);
}
