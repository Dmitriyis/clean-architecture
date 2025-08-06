package com.course.cleanarchitecture.entity.analysis.plugins.database.repository;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.GetAnalysisByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetAnalysisById implements GetAnalysisByIdProvider {

    private final AnalysisRepositoryJpa analysisRepositoryJpa;

    @Override
    public Optional<AnalysisEntity> execute(UUID id) {
        return analysisRepositoryJpa.findById(id);
    }
}
