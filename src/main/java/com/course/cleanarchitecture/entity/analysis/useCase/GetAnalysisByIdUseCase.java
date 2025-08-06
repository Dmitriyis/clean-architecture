package com.course.cleanarchitecture.entity.analysis.useCase;

import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;

import java.util.UUID;

public interface GetAnalysisByIdUseCase {
    AnalysisResponseDto execute(UUID id);
}
