package com.course.cleanarchitecture.domain.analysis.adapters.out;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AnalysisRepositoryImpl implements AnalysisRepository {

    private final AnalysisRepositoryJpa analysisRepositoryJpa;

    @Override
    public UUID save(Analysis analysis) {
        AnalysisEntity analysisEntity = AnalysisToAnalysisEntityMapper.analysisToAnalysisEntityMapper(analysis);
        analysisRepositoryJpa.save(analysisEntity);

        return analysisEntity.getId();
    }
}
