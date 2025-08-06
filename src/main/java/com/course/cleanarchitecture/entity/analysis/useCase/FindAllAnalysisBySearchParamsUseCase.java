package com.course.cleanarchitecture.entity.analysis.useCase;

import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisResponseDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisSearchParamsDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;

import java.util.List;

public interface FindAllAnalysisBySearchParamsUseCase {
    List<AnalysisResponseDto> execute(AnalysisSearchParamsDto analysisSearchParamsDto);
}
