package com.course.cleanarchitecture.entity.pet.adapter.database.repository;

import com.course.cleanarchitecture.entity.pet.port.DeletePetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeletePetByIdImpl implements DeletePetByIdPort {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        petRepositoryJpa.deleteById(id);
        return id;
    }
}
