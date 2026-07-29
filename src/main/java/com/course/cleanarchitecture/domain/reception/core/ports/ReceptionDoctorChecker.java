package com.course.cleanarchitecture.domain.reception.core.ports;

import java.util.UUID;

public interface ReceptionDoctorChecker {
    boolean isDoctorExists(UUID doctorId);
}
