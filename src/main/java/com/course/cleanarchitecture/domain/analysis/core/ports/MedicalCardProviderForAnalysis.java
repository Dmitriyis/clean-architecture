package com.course.cleanarchitecture.domain.analysis.core.ports;

import java.util.UUID;

public interface MedicalCardProviderForAnalysis {
    boolean isMedicalCardExists(UUID medicalCardId);
}
