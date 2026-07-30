package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.domain.analysis.core.application.AnalysisAppMapper;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import com.course.cleanarchitecture.domain.analysis.core.ports.MedicalCardCheckerForAnalysis;
import com.course.cleanarchitecture.domain.analysis.exceptions.MedicalCardNotFoundForAnalysisException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllAnalysisByMedicalCardIdQueryHandlerImpl implements GetAllAnalysisByMedicalCardIdQueryHandler {

    private final AnalysisAppMapper analysisAppMapper;
    private final AnalysisRepository analysisRepository;

    @Override
    public List<GetAllAnalysisByMedicalCardIdResult> execute(GetAllAnalysisByMedicalCardIdQuery query) {
        return analysisRepository.findAllByMedicalCardId(query.getMedicalCardId())
                .stream()
                .map(analysisAppMapper::toGetAnalysisByMedicalCardIdResult)
                .toList();
    }
}
