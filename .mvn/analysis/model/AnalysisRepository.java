package com.course.cleanarchitecture.domain.analysis.model;

import java.util.List;
import java.util.UUID;

public interface AnalysisRepository {
    UUID save(AnalysisEntity pet);

    List<AnalysisEntity> findAllBySearchParams(String name, Integer age, String city);
    List<AnalysisEntity> findAllBySearchParams(String name, String city);
}
