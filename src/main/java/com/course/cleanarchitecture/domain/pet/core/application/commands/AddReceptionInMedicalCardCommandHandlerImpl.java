package com.course.cleanarchitecture.domain.pet.core.application.commands;

import com.course.cleanarchitecture.domain.pet.core.model.Pet;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddReceptionInMedicalCardCommandHandlerImpl implements AddReceptionInMedicalCardCommandHandler {

    private final PetRepository petRepository;

    @Override
    @Transactional
    public void execute(AddReceptionInMedicalCardCommand addReceptionInMedicalCardCommand) throws NoSuchFieldException {
        Pet pet = petRepository.findByMedicalCardId(addReceptionInMedicalCardCommand.getMedicalCardId());

        pet.addReception(addReceptionInMedicalCardCommand.getReceptionId());

        petRepository.update(pet);
    }
}
