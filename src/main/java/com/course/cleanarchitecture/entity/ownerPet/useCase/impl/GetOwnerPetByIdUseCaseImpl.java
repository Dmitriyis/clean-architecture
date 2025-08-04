package com.course.cleanarchitecture.entity.ownerPet.useCase.impl;

import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.GetOwnerPetByIdUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.GetOwnerPetByIdProvider;
import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GetOwnerPetByIdUseCaseImpl implements GetOwnerPetByIdUseCase {

    private final GetOwnerPetByIdProvider getOwnerPetByIdProvider;

    @Override
    public OwnerPetEntity execute(UUID id) {
        return getOwnerPetByIdProvider.execute(id)
                .orElseThrow(() -> {
                    String message = PetNotFoundException.prepareMessage("OwnerPetEntity", "id", id.toString());
                    return new OwnerPetNotFoundException(message);
                });
    }
}
