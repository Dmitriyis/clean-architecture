package com.course.cleanarchitecture.domain.reception.core.application.commands;

import com.course.cleanarchitecture.domain.DomainEventPublisher;
import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import com.course.cleanarchitecture.domain.reception.core.ports.ReceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateReceptionCommandHandlerImpl implements CreateReceptionCommandHandler {

    private final ReceptionRepository receptionRepository;

    @Qualifier("outboxDomainEventPublisherImpl")
    private final DomainEventPublisher domainEventPublisher;

    @Override
    @Transactional
    public UUID execute(CreateReceptionCommand createPetCommand) {
        Reception reception = new Reception(UUID.randomUUID(), createPetCommand.getMedicalCardId(), createPetCommand.getDoctorId(), createPetCommand.getAnalyses(), createPetCommand.getConclusions(), createPetCommand.getStartReception(), createPetCommand.getEndReception());

        UUID id = receptionRepository.save(reception);

        domainEventPublisher.publish(List.of(reception));
        return id;
    }
}
