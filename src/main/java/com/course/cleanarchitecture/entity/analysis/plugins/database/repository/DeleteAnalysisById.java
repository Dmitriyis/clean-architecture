package com.course.cleanarchitecture.entity.analysis.plugins.database.repository;

import com.course.cleanarchitecture.entity.analysis.useCase.provider.DeleteAnalysisByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeleteAnalysisById implements DeleteAnalysisByIdProvider {

    private final AnalysisRepositoryJpa analysisRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        analysisRepositoryJpa.deleteById(id);
        return id;
    }
}
