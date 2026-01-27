package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllAnalysisByMedicalCardIdCommandHandlerImpl implements GetAllAnalysisByMedicalCardIdCommandHandler {

    private final AnalysisRepository analysisRepository;

    @Override
    public List<GetAllAnalysisByMedicalCardIdResponse> execute(GetAllAnalysisByMedicalCardIdCommand getAllAnalysisByMedicalCardIdCommand) throws NoSuchFieldException {
        return analysisRepository.findAllByMedicalCardId(getAllAnalysisByMedicalCardIdCommand.getMedicalCardId())
                .stream()
                .map(analyses -> new GetAllAnalysisByMedicalCardIdResponse(analyses.getName(), analyses.getDescription(), analyses.getExecutionTime(), analyses.getMedicalCardId(), analyses.getCreateDate()))
                .toList();
    }
}
