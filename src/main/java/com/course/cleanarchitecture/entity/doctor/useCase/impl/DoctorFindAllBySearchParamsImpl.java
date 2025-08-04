package com.course.cleanarchitecture.entity.doctor.useCase.impl;

import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.PetRepository;
import com.course.cleanarchitecture.entity.pet.model.useCase.PetFindAllBySearchParams;

import java.util.List;

public class DoctorFindAllBySearchParamsImpl implements PetFindAllBySearchParams {

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
