package com.course.cleanarchitecture.domain.analysis.adapters.out.postgres;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalysisJpaMapper {
    public AnalysisEntity toAnalysisEntity(Analysis analysisDirectory) {
        AnalysisEntity analysisDirectoryEntity = AnalysisEntity
                .builder()
                .id(analysisDirectory.getId())
                .name(analysisDirectory.getName())
                .description(analysisDirectory.getDescription())
                .executionTime(analysisDirectory.getExecutionTime())
                .medicalCardId(analysisDirectory.getMedicalCardId())
                .createTime(analysisDirectory.getCreateTime())
                .build();

        return analysisDirectoryEntity;
    }

    public Analysis toAnalysis(AnalysisEntity analysisEntity) {
        return Analysis.reStore(
                analysisEntity.getId(),
                analysisEntity.getName(),
                analysisEntity.getDescription(),
                analysisEntity.getExecutionTime(),
                analysisEntity.getMedicalCardId(),
                analysisEntity.getCreateTime()
        );
    }

    public List<Analysis> toAnalysisList(List<AnalysisEntity> analysisEntity) {
        return analysisEntity.stream()
                .map(this::toAnalysis)
                .collect(Collectors.toList());
    }
}
