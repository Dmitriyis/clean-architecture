package com.course.cleanarchitecture.entity.pet.adapter.database.repository;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.port.GetPetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetPetByIdImpl implements GetPetByIdPort {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public Optional<PetEntity> execute(UUID id) {
        return petRepositoryJpa.findById(id);
    }
}
