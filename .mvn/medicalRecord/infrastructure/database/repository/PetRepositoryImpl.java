package com.course.cleanarchitecture.entity.medicalRecord.infrastructure.database.repository;

import com.course.cleanarchitecture.entity.pet.adapter.database.repository.PetRepositoryJpa;
import com.course.cleanarchitecture.entity.pet.adapter.database.repository.PetSearchParamsInfra;
import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.PetRepository;

import java.util.List;
import java.util.UUID;

public class PetRepositoryImpl implements PetRepository {
    private PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID save(OwnerPetEntity petEntity) {
        return null;
    }

    @Override
    public List<OwnerPetEntity> findAllBySearchParams(String name, Integer age, String city) {
        PetSearchParamsInfra petSearchParams = PetSearchParamsInfra
                .builder()
                .name(name)
                .age(age)
                .city(city)
                .build();

        return petRepositoryJpa.findAll(petSearchParams);
    }

    @Override
    public List<OwnerPetEntity> findAllBySearchParams(String name, String city) {
        PetSearchParamsInfra petSearchParams = PetSearchParamsInfra
                .builder()
                .name(name)
                .city(city)
                .build();

        return petRepositoryJpa.findAll(petSearchParams);
    }
}
