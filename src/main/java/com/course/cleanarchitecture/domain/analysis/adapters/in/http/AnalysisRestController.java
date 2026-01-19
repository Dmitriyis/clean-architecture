package com.course.cleanarchitecture.domain.analysis.adapters.in.http;

import com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto.AnalysisCreate;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.AddAnalysisCommand;
import com.course.cleanarchitecture.domain.analysis.core.application.commands.AddAnalysisCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/analyses")
public class AnalysisRestController {

    public final AddAnalysisCommandHandler addAnalysisCommandHandler;

    @PostMapping
    public UUID createAnalysis(@RequestBody AnalysisCreate analysisCreate) throws NoSuchFieldException {
        AddAnalysisCommand addAnalysisCommand = new AddAnalysisCommand(UUID.randomUUID(), analysisCreate.getName(), analysisCreate.getDescription(), analysisCreate.getExecutionTime(), analysisCreate.getMedicalCard());

        UUID id = addAnalysisCommandHandler.execute(addAnalysisCommand);

        return id;
    }
}
