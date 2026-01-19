package com.course.cleanarchitecture.domain.analysis.core.ports;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;

import java.util.UUID;

public interface AnalysisRepository {
    UUID save(Analysis analysis);
}
