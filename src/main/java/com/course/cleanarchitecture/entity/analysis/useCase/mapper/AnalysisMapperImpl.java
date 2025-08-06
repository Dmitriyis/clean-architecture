package com.course.cleanarchitecture.entity.analysis.useCase.mapper;


import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.model.GenerateAnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisRequestDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisResponseDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisUpdateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnalysisMapperImpl implements AnalysisMapper {

    @Override
    public AnalysisEntity toAnalysisEntity(AnalysisRequestDto analysisRequestDto, UUID id) {
        AnalysisEntity analysisEntity = GenerateAnalysisEntity.generate(id, analysisRequestDto.getName(), analysisRequestDto.getLeadTime(), analysisRequestDto.getPrice(), analysisRequestDto.getRecommendations());
        return analysisEntity;
    }

    @Override
    public AnalysisEntity toAnalysisEntity(AnalysisUpdateDto analysisUpdateDto, AnalysisEntity analysisEntity) {
        analysisEntity.updateName(analysisUpdateDto.getName());
        analysisEntity.updatePrice(analysisUpdateDto.getPrice());
        analysisEntity.updateLeadTime(analysisUpdateDto.getLeadTime());
        analysisEntity.updateRecommendations(analysisEntity.getRecommendations());
        return analysisEntity;
    }
    
    @Override
    public AnalysisResponseDto toAnalysisResponseDto(AnalysisEntity analysisEntity) {
        AnalysisResponseDto analysisResponseDto = AnalysisResponseDto
                .builder()
                .id(analysisEntity.getId())
                .name(analysisEntity.getName())
                .leadTime(analysisEntity.getLeadTime())
                .recommendations(analysisEntity.getRecommendations())
                .build();
        return analysisResponseDto;
    }
}
