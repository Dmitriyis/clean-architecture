package com.course.cleanarchitecture.entity.analysis.useCase.provider;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetAnalysisByIdProvider {
    Optional<AnalysisEntity> execute(UUID id);
}
