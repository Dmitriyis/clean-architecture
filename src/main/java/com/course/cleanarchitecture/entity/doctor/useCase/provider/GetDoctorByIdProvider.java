package com.course.cleanarchitecture.entity.doctor.useCase.provider;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetDoctorByIdProvider {
    Optional<DoctorEntity> execute(UUID id);
}
