package com.course.cleanarchitecture.entity.pet.adapter.database.repository;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.port.UpdatePetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UpdatePetImpl implements UpdatePetPort {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID execute(PetEntity petEntity) {
        return petRepositoryJpa.save(petEntity).getId();
    }
}
