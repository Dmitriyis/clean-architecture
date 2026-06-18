package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import java.util.List;

public interface GetAnalysisByMedicalCardIdQueryHandler {
    List<GetAnalysisByMedicalCardIdResult> execute(GetAnalysisByMedicalCardIdQuery getAnalysisByMedicalCardIdCommand) throws NoSuchFieldException;
}
