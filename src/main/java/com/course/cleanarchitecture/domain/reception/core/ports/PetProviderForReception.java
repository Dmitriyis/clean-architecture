package com.course.cleanarchitecture.domain.reception.core.ports;

import java.util.UUID;

public interface PetProviderForReception {
    boolean isPetExists(UUID petId);
}
