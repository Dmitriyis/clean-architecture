package com.course.cleanarchitecture.domain.reception.core.ports;

import java.util.UUID;

public interface DoctorProviderForReception {
    boolean isDoctorExists(UUID doctorId);
}
