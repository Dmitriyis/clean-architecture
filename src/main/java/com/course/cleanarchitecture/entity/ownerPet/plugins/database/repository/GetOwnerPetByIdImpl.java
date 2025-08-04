package com.course.cleanarchitecture.entity.ownerPet.plugins.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.GetOwnerPetByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetOwnerPetByIdImpl implements GetOwnerPetByIdProvider {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public Optional<OwnerPetEntity> execute(UUID id) {
        return ownerPetRepositoryJpa.findById(id);
    }
}
