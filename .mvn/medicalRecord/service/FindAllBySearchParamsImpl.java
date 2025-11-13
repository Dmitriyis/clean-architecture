package com.course.cleanarchitecture.domain.medicalRecord.service;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.pet.useCase.PetRepository;
import com.course.cleanarchitecture.domain.pet.model.useCase.PetFindAllBySearchParams;

import java.util.List;

public class FindAllBySearchParamsImpl implements PetFindAllBySearchParams {

    private PetRepository petRepository;

    @Override
    public List<OwnerPetEntity> findAllBySearchParams(String name, Integer age, String city) {
        return petRepository.findAllBySearchParams(name, age, city);
    }

    @Override
    public List<OwnerPetEntity> findAllBySearchParams(String name, String city) {
        return petRepository.findAllBySearchParams(name, city);
    }
}
