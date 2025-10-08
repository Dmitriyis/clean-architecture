package com.course.cleanarchitecture.entity.doctor.useCase;

import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;

import java.util.UUID;

public interface GetDoctorByIdUseCase {
    DoctorResponseDto execute(UUID id);
}
