package com.course.cleanarchitecture.domain.analysis.adapters.in.http;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisGet;
import com.course.cleanarchitecture.domain.analysis.adapters.in.http.mapper.AnalysisMapper;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.SaveAnalysisCommandHandler;
import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAnalysisByMedicalCardIdQuery;
import com.course.cleanarchitecture.domain.analysis.core.application.queries.GetAnalysisByMedicalCardIdQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(AnalysisConstantsHttp.ROOT_URL)
public class AnalysisGetAllByMedicalCardIdRestController {

    private final AnalysisMapper analysisMapper;
    private final GetAnalysisByMedicalCardIdQueryHandler getAllAnalysisByMedicalCardIdCommandHandler;

    @GetMapping("/medical-card/{medicalCardId}")
    public List<AnalysisGet> getAllAnalysisByMedicalCardId(@PathVariable("medicalCardId") UUID medicalCardId) throws NoSuchFieldException {

        GetAnalysisByMedicalCardIdQuery query = new GetAnalysisByMedicalCardIdQuery(medicalCardId);

        return getAllAnalysisByMedicalCardIdCommandHandler.execute(query)
                .stream()
                .map(analysisMapper::toAnalysisGet)
                .toList();
    }
}
