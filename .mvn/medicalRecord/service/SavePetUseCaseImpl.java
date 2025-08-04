package com.course.cleanarchitecture.entity.medicalRecord.service;

import com.course.cleanarchitecture.entity.medicalRecord.service.dto.PetRequestDto;
import com.course.cleanarchitecture.entity.medicalRecord.service.mapper.PetMapper;
import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.PetRepository;
import com.course.cleanarchitecture.entity.pet.model.useCase.PetSaveUseCase;

import java.util.UUID;

public class SavePetUseCaseImpl implements PetSaveUseCase {

    private PetRepository petRepository;
    private PetMapper petMapper;

    @Override
    public UUID save(PetRequestDto petRequestDto) {
        OwnerPetEntity petEntity = petMapper.toPetEntity(petRequestDto);
        return petRepository.save(petEntity);
    }
}
