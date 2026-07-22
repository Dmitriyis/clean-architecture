package com.course.cleanarchitecture.domain.analysis.adapters.in.http.mapper;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisDtoGetByMedicalCardId;
import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAllAnalysisByMedicalCardIdResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnalysisMapperApi {

    AnalysisDtoGetByMedicalCardId toAnalysisGetByMedicalCardId(GetAllAnalysisByMedicalCardIdResult getAnalysisByMedicalCardIdResult);
}
