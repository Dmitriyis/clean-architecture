package com.course.cleanarchitecture.entity.ownerPet.adapter.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.port.GetOwnerPetByIdPort;
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
