package com.course.cleanarchitecture.domain.reception.core.ports;

import java.util.UUID;

public interface DoctorCheckerForReception {
    boolean isDoctorExists(UUID doctorId);
}
