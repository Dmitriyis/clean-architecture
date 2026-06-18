package com.course.cleanarchitecture.domain.analysis.adapters.in.http.mapper;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisGet;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.GetAllAnalysisByMedicalCardIdResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnalysisMapper {

    AnalysisGet toAnalysisGet(GetAllAnalysisByMedicalCardIdResponse getAllAnalysisByMedicalCardIdResponse);
}
