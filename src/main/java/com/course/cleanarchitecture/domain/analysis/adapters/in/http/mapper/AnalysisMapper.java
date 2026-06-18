package com.course.cleanarchitecture.domain.analysis.adapters.in.http.mapper;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisGet;
import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAnalysisByMedicalCardIdResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnalysisMapper {

    AnalysisGet toAnalysisGet(GetAnalysisByMedicalCardIdResult getAnalysisByMedicalCardIdResult);
}
