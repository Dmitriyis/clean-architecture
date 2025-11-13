package com.course.cleanarchitecture.domain.ownerPet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.ownerPet.application.port.GetOwnerPetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetOwnerPetByIdImpl implements GetOwnerPetByIdPort {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public Optional<OwnerPetEntity> execute(UUID id) {
        return ownerPetRepositoryJpa.findById(id);
    }
}
