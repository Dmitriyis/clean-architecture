package com.course.cleanarchitecture.domain.analysis.core.application;

import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAllAnalysisByMedicalCardIdResult;
import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import org.springframework.stereotype.Service;

@Service
public class AnalysisAppMapper {
   public GetAllAnalysisByMedicalCardIdResult toGetAnalysisByMedicalCardIdResult(Analysis analysis) {
        return new GetAllAnalysisByMedicalCardIdResult(
                analysis.getId(),
                analysis.getName(),
                analysis.getDescription(),
                analysis.getExecutionTime(),
                analysis.getAppointmentTime()
        );
    }
}
