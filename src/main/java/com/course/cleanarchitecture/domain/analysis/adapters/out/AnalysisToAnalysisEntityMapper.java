package com.course.cleanarchitecture.domain.analysis.adapters.out;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.pet.adapters.out.postgres.MedicalCardEntity;

public class AnalysisToAnalysisEntityMapper {
    public static AnalysisEntity analysisToAnalysisEntityMapper(Analysis analysis) {
        MedicalCardEntity medicalCardEntity = MedicalCardEntity
                .builder()
                .id(analysis.getMedicalCardId())
                .build();

        AnalysisEntity analysisEntity = AnalysisEntity
                .builder()
                .id(analysis.getId())
                .name(analysis.getName())
                .description(analysis.getDescription())
                .medicalCard(medicalCardEntity)
                .executionTime(analysis.getExecutionTime())
                .build();

        return analysisEntity;
    }
}
