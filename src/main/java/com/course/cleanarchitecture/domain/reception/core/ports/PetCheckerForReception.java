package com.course.cleanarchitecture.domain.reception.core.ports;

import java.util.UUID;

public interface PetCheckerForReception {
    boolean isPetExists(UUID petId);
}
