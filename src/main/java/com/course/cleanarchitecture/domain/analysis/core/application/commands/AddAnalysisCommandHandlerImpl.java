package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddAnalysisCommandHandlerImpl implements AddAnalysisCommandHandler {

    private final AnalysisRepository analysisRepository;

    @Override
    @Transactional
    public UUID execute(AddAnalysisCommand addAnalysisCommand) throws NoSuchFieldException {
        Analysis analysis = new Analysis(UUID.randomUUID(), addAnalysisCommand.getName(), addAnalysisCommand.getDescription(), addAnalysisCommand.getExecutionTime(), addAnalysisCommand.getMedicalCard(), LocalDateTime.now());

        return analysisRepository.save(analysis);
    }
}
