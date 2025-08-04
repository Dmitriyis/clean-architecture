package com.course.cleanarchitecture.entity.pet.plugins.database.repository;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.provider.GetPetByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetPetByIdImpl implements GetPetByIdProvider {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public Optional<PetEntity> execute(UUID id) {
        return petRepositoryJpa.findById(id);
    }
}
