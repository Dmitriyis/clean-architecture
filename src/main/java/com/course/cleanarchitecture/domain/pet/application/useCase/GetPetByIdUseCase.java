package com.course.cleanarchitecture.domain.pet.application.useCase;

import com.course.cleanarchitecture.domain.pet.exceptions.PetNotFoundException;
import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import com.course.cleanarchitecture.domain.pet.application.port.GetPetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetPetByIdUseCase {

    private final GetPetByIdPort getPetByIdPort;

    public PetEntity execute(UUID id) {
        return getPetByIdPort.execute(id)
                .orElseThrow(() -> {
                    String message = PetNotFoundException.prepareMessage("PetEntity", "id", id.toString());
                    return new PetNotFoundException(message);
                });
    }
}
