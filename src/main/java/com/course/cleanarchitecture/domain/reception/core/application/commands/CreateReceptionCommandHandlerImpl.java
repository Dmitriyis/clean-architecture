package com.course.cleanarchitecture.domain.reception.core.application.commands;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.domain.DomainEventPublisher;
import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import com.course.cleanarchitecture.domain.reception.core.ports.DoctorProviderForReception;
import com.course.cleanarchitecture.domain.reception.core.ports.PetProviderForReception;
import com.course.cleanarchitecture.domain.reception.core.ports.ReceptionRepository;
import com.course.cleanarchitecture.domain.reception.exceptions.DoctorNotFoundForReceptionException;
import com.course.cleanarchitecture.domain.reception.exceptions.PetNotFoundForReceptionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CreateReceptionCommandHandlerImpl implements CreateReceptionCommandHandler {

    private final DoctorProviderForReception doctorProviderForReception;
    private final PetProviderForReception petProviderForReception;
    private final ReceptionRepository receptionRepository;
    private final DomainEventPublisher domainEventPublisher;

    public CreateReceptionCommandHandlerImpl(DoctorProviderForReception doctorProviderForReception,
                                             PetProviderForReception petProviderForReception,
                                             ReceptionRepository receptionRepository,
                                             DomainEventPublisher domainEventPublisher) {
        this.doctorProviderForReception = doctorProviderForReception;
        this.petProviderForReception = petProviderForReception;
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

        verifyPetExists(reception.getPetId());

        verifyDoctorExists(reception.getDoctorId());

        UUID id = receptionRepository.save(reception);

        domainEventPublisher.publish(List.of(reception));

        return id;
    }

    private void verifyDoctorExists(UUID doctorId) {
        boolean doctorExists = doctorProviderForReception.isDoctorExists(doctorId);

        if (!doctorExists) {
            String message = NotFoundException.prepareMessage("Doctor", "id", doctorId.toString());
            throw new DoctorNotFoundForReceptionException(message);
        }
    }

    private void verifyPetExists(UUID petId) {
        boolean petExists = petProviderForReception.isPetExists(petId);

        if (!petExists) {
            String message = NotFoundException.prepareMessage("Pet", "id", petId.toString());
            throw new PetNotFoundForReceptionException(message);
        }
    }
}
