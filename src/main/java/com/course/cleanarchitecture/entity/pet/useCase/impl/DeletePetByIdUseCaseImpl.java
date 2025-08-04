package com.course.cleanarchitecture.entity.pet.useCase.impl;

import com.course.cleanarchitecture.entity.pet.useCase.DeletePetByIdUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.provider.DeletePetByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeletePetByIdUseCaseImpl implements DeletePetByIdUseCase {

    private final DeletePetByIdProvider deletePetByIdProvider;

    @Override
    public UUID execute(UUID id) {
        return deletePetByIdProvider.execute(id);
    }
}
