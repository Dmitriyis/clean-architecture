package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.pet.exceptions.MedicalCardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.course.cleanarchitecture.domain.analysis.core.model.Analysis.createAnalysis;

@Service
@RequiredArgsConstructor
public class CreateAnalysisCommandHandlerImpl implements CreateAnalysisCommandHandler {

    private final PetRepository petRepository;
    private final AnalysisRepository analysisRepository;

    @Override
    @Transactional
    public UUID execute(CreateAnalysisCommand command) {
        if (!petRepository.existsPetByMedicalCardId(command.getMedicalCardId())) {
            throw new MedicalCardNotFoundException("Medical card not found with id: " + command.getMedicalCardId());
        }

        Analysis analysis = createAnalysis(
                UUID.randomUUID(),
                command.getName(),
                command.getDescription(),
                command.getExecutionTime(),
                command.getMedicalCardId(),
                LocalDateTime.now()
        );

        return analysisRepository.save(analysis);
    }
}
