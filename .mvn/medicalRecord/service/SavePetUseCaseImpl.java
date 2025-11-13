package com.course.cleanarchitecture.domain.medicalRecord.service;

import com.course.cleanarchitecture.domain.medicalRecord.service.dto.PetRequestDto;
import com.course.cleanarchitecture.domain.medicalRecord.service.mapper.PetMapper;
import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.pet.useCase.PetRepository;
import com.course.cleanarchitecture.domain.pet.model.useCase.PetSaveUseCase;

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
