package com.course.cleanarchitecture.entity.doctor.useCase.provider;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;

import java.util.UUID;

public interface GetDoctorByIdProvider {
    DoctorEntity execute(UUID id);
}
