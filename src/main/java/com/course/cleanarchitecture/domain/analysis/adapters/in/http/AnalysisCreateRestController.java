package com.course.cleanarchitecture.domain.analysis.adapters.in.http;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisCreate;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.CreateAnalysisCommand;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.CreateAnalysisCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(AnalysisConstantsHttp.ROOT_URL)
public class AnalysisCreateRestController {

    private final CreateAnalysisCommandHandler createAnalysisCommandHandler;

    @PostMapping
    public UUID createAnalysis(@RequestBody AnalysisCreate analysisCreate) {

        CreateAnalysisCommand command = new CreateAnalysisCommand(analysisCreate.getName(), analysisCreate.getDescription(), analysisCreate.getExecutionTime(), analysisCreate.getMedicalCard());

        return createAnalysisCommandHandler.execute(command);
    }
}
