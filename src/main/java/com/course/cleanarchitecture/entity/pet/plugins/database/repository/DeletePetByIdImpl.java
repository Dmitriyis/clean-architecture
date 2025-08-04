package com.course.cleanarchitecture.entity.pet.plugins.database.repository;

import com.course.cleanarchitecture.entity.pet.useCase.provider.DeletePetByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeletePetByIdImpl implements DeletePetByIdProvider {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        petRepositoryJpa.deleteById(id);
        return id;
    }
}
