package com.course.cleanarchitecture.entity.pet.useCase.impl;

import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.GetPetByIdUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.provider.GetPetByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GetPetByIdUseCaseImpl implements GetPetByIdUseCase {

    private final GetPetByIdProvider getPetByIdProvider;

    @Override
    public PetEntity execute(UUID id) {
        return getPetByIdProvider.execute(id)
                .orElseThrow(() -> {
                    String message = PetNotFoundException.prepareMessage("PetEntity", "id", id.toString());
                    return new PetNotFoundException(message);
                });
    }
}
