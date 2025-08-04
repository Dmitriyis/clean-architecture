package com.course.cleanarchitecture.entity.doctor.useCase;

import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.util.UUID;

public interface GetDoctorByIdUseCase {
    DoctorResponseDto execute(UUID id);
}
