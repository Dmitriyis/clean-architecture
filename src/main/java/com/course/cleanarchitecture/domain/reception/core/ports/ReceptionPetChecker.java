package com.course.cleanarchitecture.domain.reception.core.ports;

import java.util.UUID;

public interface ReceptionPetChecker {
    boolean isPetExists(UUID petId);
}
