package com.course.cleanarchitecture.entity.ownerPet.useCase.impl;

import com.course.cleanarchitecture.entity.ownerPet.useCase.DeleteOwnerPetByIdUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.DeleteOwnerPetByIdProvider;
import com.course.cleanarchitecture.entity.pet.useCase.DeletePetByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteOwnerPetByIdUseCaseImpl implements DeleteOwnerPetByIdUseCase {

    private final DeleteOwnerPetByIdProvider deleteOwnerPetByIdProvider;

    @Override
    public UUID execute(UUID id) {
        return deleteOwnerPetByIdProvider.execute(id);
    }
}
