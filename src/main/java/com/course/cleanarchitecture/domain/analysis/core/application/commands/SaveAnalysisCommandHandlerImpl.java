package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.course.cleanarchitecture.domain.analysis.core.model.Analysis.createAnalysis;

@Service
@RequiredArgsConstructor
public class SaveAnalysisCommandHandlerImpl implements SaveAnalysisCommandHandler {

    private final AnalysisRepository analysisRepository;

    @Override
    @Transactional
    public UUID execute(SaveAnalysisCommand saveAnalysisCommand) {
        Analysis analysis = createAnalysis(
                UUID.randomUUID(),
                saveAnalysisCommand.getName(),
                saveAnalysisCommand.getDescription(),
                saveAnalysisCommand.getExecutionTime(),
                saveAnalysisCommand.getMedicalCard(),
                LocalDateTime.now()
        );

        return analysisRepository.save(analysis);
    }
}
