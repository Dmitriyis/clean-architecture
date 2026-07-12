package com.course.cleanarchitecture.domain.analysis.adapters.out.postgres;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AnalysisRepositoryImpl implements AnalysisRepository {

    private final AnalysisJpaMapper analysisJpaMapper;
    private final AnalysisRepositoryJpa analysisRepositoryJpa;

    @Override
    public UUID save(Analysis analysis) {
        AnalysisEntity analysisEntity = analysisJpaMapper.toAnalysisEntity(analysis);
        analysisRepositoryJpa.save(analysisEntity);

        return analysisEntity.getId();
    }

    @Override
    public List<Analysis> findAllByMedicalCardId(UUID medicalCardId) {
        List<AnalysisEntity> analysisEntities = analysisRepositoryJpa.findAllByMedicalCardId(medicalCardId);

        return analysisJpaMapper.toAnalysisList(analysisEntities);
    }
}
