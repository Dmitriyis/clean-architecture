package com.course.cleanarchitecture.domain.analysis.core.ports;

import java.util.UUID;

public interface ReceptionMedicalCardChecker {
    boolean isMedicalCardExists(UUID medicalCardId);
}
