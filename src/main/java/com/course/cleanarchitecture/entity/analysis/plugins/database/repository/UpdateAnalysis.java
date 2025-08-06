package com.course.cleanarchitecture.entity.analysis.plugins.database.repository;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.UpdateAnalysisProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UpdateAnalysis implements UpdateAnalysisProvider {

    private final AnalysisRepositoryJpa analysisRepositoryJpa;

    @Override
    public UUID execute(AnalysisEntity analysisEntity) {
        return analysisRepositoryJpa.save(analysisEntity).getId();
    }
}
