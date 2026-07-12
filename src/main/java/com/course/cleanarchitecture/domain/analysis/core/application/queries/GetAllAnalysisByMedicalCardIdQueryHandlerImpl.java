package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import com.course.cleanarchitecture.domain.analysis.core.application.AnalysisAppMapper;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.pet.exceptions.MedicalCardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllAnalysisByMedicalCardIdQueryHandlerImpl implements GetAllAnalysisByMedicalCardIdQueryHandler {

    private final AnalysisAppMapper analysisAppMapper;
    private final PetRepository petRepository;
    private final AnalysisRepository analysisRepository;

    @Override
    public List<GetAllAnalysisByMedicalCardIdResult> execute(GetAllAnalysisByMedicalCardIdQuery query) {

        if (!petRepository.existsPetByMedicalCardId(query.getMedicalCardId())) {
            throw new MedicalCardNotFoundException("Medical card not found with id: " + query.getMedicalCardId());
        }

        return analysisRepository.findAllByMedicalCardId(query.getMedicalCardId())
                .stream()
                .map(analysisAppMapper::toGetAnalysisByMedicalCardIdResult)
                .toList();
    }
}
