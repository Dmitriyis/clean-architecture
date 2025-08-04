package com.course.cleanarchitecture.entity.doctor.useCase.impl;

import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.PetRepository;
import com.course.cleanarchitecture.entity.pet.model.useCase.PetSaveUseCase;

import java.util.UUID;

public class DoctorSaveUseCaseImpl implements DoctorNewAppointmentUseCase {

    private PetRepository petRepository;
    private DoctorMapper petMapper;

    @Override
    public UUID save(DoctorRequestDto petRequestDto) {
        OwnerPetEntity petEntity = petMapper.toPetEntity(petRequestDto);
        return petRepository.save(petEntity);
    }
}
