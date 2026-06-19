package com.course.cleanarchitecture.domain.analysis.adapters.in.http.mapper;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisGetByMedicalCardId;
import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAnalysisByMedicalCardIdResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnalysisMapper {

    AnalysisGetByMedicalCardId toAnalysisGet(GetAnalysisByMedicalCardIdResult getAnalysisByMedicalCardIdResult);
}
