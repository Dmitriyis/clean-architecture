package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.domain.analysis.core.application.AnalysisAppMapper;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import com.course.cleanarchitecture.domain.analysis.core.ports.ReceptionMedicalCardChecker;
import com.course.cleanarchitecture.domain.analysis.exceptions.MedicalCardNotFoundForAnalysisException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllAnalysisByMedicalCardIdQueryHandlerImpl implements GetAllAnalysisByMedicalCardIdQueryHandler {

    private final AnalysisAppMapper analysisAppMapper;
    private final AnalysisRepository analysisRepository;
    private final ReceptionMedicalCardChecker receptionMedicalCardChecker;

    @Override
    public List<GetAllAnalysisByMedicalCardIdResult> execute(GetAllAnalysisByMedicalCardIdQuery query) {

        boolean isExists = receptionMedicalCardChecker.isMedicalCardExists(query.getMedicalCardId());

        if (!isExists) {
            String message = NotFoundException.prepareMessage("medicalCard", "medicalCardId", query.getMedicalCardId().toString());
            throw new MedicalCardNotFoundForAnalysisException(message);
        }

        return analysisRepository.findAllByMedicalCardId(query.getMedicalCardId())
                .stream()
                .map(analysisAppMapper::toGetAnalysisByMedicalCardIdResult)
                .toList();
    }
}
