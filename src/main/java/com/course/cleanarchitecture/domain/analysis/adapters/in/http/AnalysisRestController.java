package com.course.cleanarchitecture.domain.analysis.adapters.in.http;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisCreate;
import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisGet;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.AddAnalysisCommand;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.AddAnalysisCommandHandler;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.GetAllAnalysisByMedicalCardIdCommand;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.GetAllAnalysisByMedicalCardIdCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/analyses")
public class AnalysisRestController {

    public final AddAnalysisCommandHandler addAnalysisCommandHandler;
    private final GetAllAnalysisByMedicalCardIdCommandHandler getAllAnalysisByMedicalCardIdCommandHandler;

    @PostMapping
    public UUID createAnalysis(@RequestBody AnalysisCreate analysisCreate) throws NoSuchFieldException {
        AddAnalysisCommand addAnalysisCommand = new AddAnalysisCommand(analysisCreate.getName(), analysisCreate.getDescription(), analysisCreate.getExecutionTime(), analysisCreate.getMedicalCard());

        return addAnalysisCommandHandler.execute(addAnalysisCommand);
    }

    @GetMapping
    public List<AnalysisGet> getAllAnalysisByMedicalCardId(@RequestParam("medicalCardId") UUID medicalCardId) throws NoSuchFieldException {
        GetAllAnalysisByMedicalCardIdCommand getAllAnalysisByMedicalCardIdCommand = new GetAllAnalysisByMedicalCardIdCommand(medicalCardId);
        return getAllAnalysisByMedicalCardIdCommandHandler.execute(getAllAnalysisByMedicalCardIdCommand)
                .stream()
                .map(analyses -> new AnalysisGet(analyses.getName(), analyses.getDescription(), analyses.getExecutionTime(), analyses.getMedicalCardId(), analyses.getCreateDate()))
                .toList();
    }
}
