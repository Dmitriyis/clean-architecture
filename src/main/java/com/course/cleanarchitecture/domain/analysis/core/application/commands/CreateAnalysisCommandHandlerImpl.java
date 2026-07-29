package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.domain.analysis.core.model.Analysis;
import com.course.cleanarchitecture.domain.analysis.core.ports.AnalysisRepository;
import com.course.cleanarchitecture.domain.analysis.core.ports.ReceptionMedicalCardChecker;
import com.course.cleanarchitecture.domain.analysis.exceptions.MedicalCardNotFoundForAnalysisException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.course.cleanarchitecture.domain.analysis.core.model.Analysis.create;

@Service
@RequiredArgsConstructor
public class CreateAnalysisCommandHandlerImpl implements CreateAnalysisCommandHandler {

    private final AnalysisRepository analysisRepository;
    private final ReceptionMedicalCardChecker receptionMedicalCardChecker;

    @Override
    @Transactional
    public UUID execute(CreateAnalysisCommand command) {

        boolean isExists = receptionMedicalCardChecker.isMedicalCardExists(command.getMedicalCardId());

        if (!isExists) {
            String message = NotFoundException.prepareMessage("medicalCard", "medicalCardId", command.getMedicalCardId().toString());
            throw new MedicalCardNotFoundForAnalysisException(message);
        }

        Analysis analysis = create(
                UUID.randomUUID(),
                command.getName(),
                command.getDescription(),
                command.getExecutionTime(),
                command.getMedicalCardId(),
                command.getCreateTime()
        );

        return analysisRepository.save(analysis);
    }
}
