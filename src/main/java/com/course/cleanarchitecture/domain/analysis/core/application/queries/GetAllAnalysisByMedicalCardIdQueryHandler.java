package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import java.util.List;

public interface GetAllAnalysisByMedicalCardIdQueryHandler {
    List<GetAllAnalysisByMedicalCardIdResult> execute(GetAllAnalysisByMedicalCardIdQuery query);
}
