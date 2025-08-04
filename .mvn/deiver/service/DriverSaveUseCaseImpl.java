package com.course.cleanarchitecture.entity.deiver.service;

import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.PetRepository;
import com.course.cleanarchitecture.entity.pet.model.useCase.PetSaveUseCase;
import com.course.cleanarchitecture.entity.deiver.service.dto.DriverDto;
import com.course.cleanarchitecture.entity.deiver.service.mapper.DriverMapper;

import java.util.UUID;

public class DriverSaveUseCaseImpl implements PetSaveUseCase {

    private PetRepository petRepository;
    private DriverMapper petMapper;

    @Override
    public UUID save(DriverDto petRequestDto) {
        OwnerPetEntity petEntity = petMapper.toPetEntity(petRequestDto);
        return petRepository.save(petEntity);
    }
}
