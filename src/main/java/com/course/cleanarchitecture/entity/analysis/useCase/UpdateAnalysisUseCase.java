package com.course.cleanarchitecture.entity.analysis.useCase;

import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisUpdateDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;

import java.util.UUID;

public interface UpdateAnalysisUseCase {
    UUID execute(AnalysisUpdateDto analysisResponseDto);
}
