package com.course.cleanarchitecture.domain.analysis.adapters.in.http;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisDtoGetByMedicalCardId;
import com.course.cleanarchitecture.domain.analysis.adapters.in.http.mapper.AnalysisMapperApi;
import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAllAnalysisByMedicalCardIdQuery;
import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAllAnalysisByMedicalCardIdQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(AnalysisConstantsHttp.ROOT_URL)
public class AnalysisGetAllByMedicalCardIdRestController {

    private final AnalysisMapperApi analysisMapper;
    private final GetAllAnalysisByMedicalCardIdQueryHandler getAnalysisByMedicalCardIdQueryHandler;

    @GetMapping("/medical-card/{medicalCardId}")
    public List<AnalysisDtoGetByMedicalCardId> getAllAnalysisDirectoryByMedicalCardId(@PathVariable("medicalCardId") UUID medicalCardId) {

        GetAllAnalysisByMedicalCardIdQuery query = new GetAllAnalysisByMedicalCardIdQuery(medicalCardId);

        return getAnalysisByMedicalCardIdQueryHandler.execute(query)
                .stream()
                .map(analysisMapper::toAnalysisGetByMedicalCardId)
                .toList();
    }
}
