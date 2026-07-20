package com.course.cleanarchitecture.domain.reception.core.application.commands;

import com.course.cleanarchitecture.domain.DomainEventPublisher;
import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import com.course.cleanarchitecture.domain.reception.core.ports.ReceptionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CreateReceptionCommandHandlerImpl implements CreateReceptionCommandHandler {

    private final ReceptionRepository receptionRepository;
    private final DomainEventPublisher domainEventPublisher;

    public CreateReceptionCommandHandlerImpl(ReceptionRepository receptionRepository,
                                             @Qualifier("domainEventOutboxPublisherImpl") DomainEventPublisher domainEventPublisher) {
        this.receptionRepository = receptionRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    @Transactional
    public UUID execute(CreateReceptionCommand command) {
        Reception reception = Reception.create(UUID.randomUUID(),
                command.getPetId(),
                command.getDoctorId(),
                command.getAnalyses(),
                command.getDescription(),
                command.getStartReception(),
                command.getEndReception()
        );

        UUID id = receptionRepository.save(reception);

        domainEventPublisher.publish(List.of(reception));

        return id;
    }
}
