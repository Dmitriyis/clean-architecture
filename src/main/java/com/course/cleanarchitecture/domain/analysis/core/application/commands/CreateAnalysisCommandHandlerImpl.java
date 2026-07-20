package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.course.cleanarchitecture.domain.analysis.core.model.Analysis.create;

@Service
@RequiredArgsConstructor
public class CreateAnalysisCommandHandlerImpl implements CreateAnalysisCommandHandler {

    private final PetRepository petRepository;
    private final AnalysisRepository analysisRepository;

    @Override
    @Transactional
    public UUID execute(CreateAnalysisCommand command) {

//      petRepository.findById();

        Analysis analysis = create(
                UUID.randomUUID(),
                command.getName(),
                command.getDescription(),
                command.getExecutionTime(),
                command.getMedicalCard(),
                command.getCreateTime()
        );

        return analysisRepository.save(analysis);
    }
}
