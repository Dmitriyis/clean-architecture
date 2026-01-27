package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import java.util.List;

public interface GetAllAnalysisByMedicalCardIdCommandHandler {
    List<GetAllAnalysisByMedicalCardIdResponse> execute(GetAllAnalysisByMedicalCardIdCommand getAllAnalysisByMedicalCardIdCommand) throws NoSuchFieldException;
}
