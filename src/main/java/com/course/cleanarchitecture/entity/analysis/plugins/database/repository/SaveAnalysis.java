package com.course.cleanarchitecture.entity.analysis.plugins.database.repository;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.SaveAnalysisProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SaveAnalysis implements SaveAnalysisProvider {

    private final AnalysisRepositoryJpa analysisRepositoryJpa;

    @Override
    public UUID execute(AnalysisEntity analysisEntity) {
        return analysisRepositoryJpa.save(analysisEntity).getId();
    }
}
