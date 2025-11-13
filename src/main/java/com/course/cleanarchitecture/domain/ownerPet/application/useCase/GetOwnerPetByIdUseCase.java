package com.course.cleanarchitecture.domain.ownerPet.application.useCase;

import com.course.cleanarchitecture.domain.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.ownerPet.application.port.GetOwnerPetByIdPort;
import com.course.cleanarchitecture.domain.pet.exceptions.PetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GetOwnerPetByIdUseCase {

    private final GetOwnerPetByIdPort getOwnerPetByIdPort;

    public OwnerPetEntity execute(UUID id) {
        return getOwnerPetByIdPort.execute(id)
                .orElseThrow(() -> {
                    String message = PetNotFoundException.prepareMessage("OwnerPetEntity", "id", id.toString());
                    return new OwnerPetNotFoundException(message);
                });
    }
}
