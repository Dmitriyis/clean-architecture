package com.course.cleanarchitecture.domain.deiver.service;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.pet.useCase.PetRepository;
import com.course.cleanarchitecture.domain.pet.model.useCase.PetSaveUseCase;
import com.course.cleanarchitecture.domain.deiver.service.dto.DriverDto;
import com.course.cleanarchitecture.domain.deiver.service.mapper.DriverMapper;

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
