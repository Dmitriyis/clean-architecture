package com.course.cleanarchitecture.domain.analysis.core.ports;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;

import java.util.List;
import java.util.UUID;


public interface AnalysisRepository {
    UUID save(Analysis analysis);
    List<Analysis> findAllByMedicalCardId(UUID medicalCardId);
}
