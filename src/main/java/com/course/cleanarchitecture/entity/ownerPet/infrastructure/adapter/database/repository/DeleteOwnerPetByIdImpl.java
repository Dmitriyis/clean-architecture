package com.course.cleanarchitecture.entity.ownerPet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.application.port.DeleteOwnerPetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeleteOwnerPetByIdImpl implements DeleteOwnerPetByIdPort {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        ownerPetRepositoryJpa.deleteById(id);
        return id;
    }
}
