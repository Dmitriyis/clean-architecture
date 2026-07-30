package com.course.cleanarchitecture.domain.analysis.core.ports;

import java.util.UUID;

public interface MedicalCardCheckerForAnalysis {
    boolean isMedicalCardExists(UUID medicalCardId);
}
