package com.course.cleanarchitecture.entity.analysis.useCase.provider;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisSearchParamsDto;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;

import java.util.List;

public interface FindAllAnalysisBySearchParamsProvider {

    List<AnalysisEntity> execute(AnalysisSearchParamsDto analysisSearchParamsDto);
}
