package com.course.cleanarchitecture.entity.analysis.useCase.mapper;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisRequestDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisResponseDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisUpdateDto;

import java.util.UUID;

public interface AnalysisMapper {

    AnalysisEntity toAnalysisEntity(AnalysisRequestDto analysisRequestDto, UUID id);

    AnalysisEntity toAnalysisEntity(AnalysisUpdateDto analysisUpdateDto, AnalysisEntity analysisEntity);

    AnalysisResponseDto toAnalysisResponseDto(AnalysisEntity analysisEntity);
}
