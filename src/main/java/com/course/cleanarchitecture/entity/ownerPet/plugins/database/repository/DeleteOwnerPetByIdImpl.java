package com.course.cleanarchitecture.entity.ownerPet.plugins.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.DeleteOwnerPetByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeleteOwnerPetByIdImpl implements DeleteOwnerPetByIdProvider {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        ownerPetRepositoryJpa.deleteById(id);
        return id;
    }
}
