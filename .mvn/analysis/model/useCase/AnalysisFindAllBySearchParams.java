package com.course.cleanarchitecture.entity.analysis.model.useCase;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;

import java.util.List;

public interface AnalysisFindAllBySearchParams {
    List<AnalysisEntity> findAllBySearchParams(String name, Integer age, String city);
    List<AnalysisEntity> findAllBySearchParams(String name, String city);
}
