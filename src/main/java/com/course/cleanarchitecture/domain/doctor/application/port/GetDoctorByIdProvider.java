package com.course.cleanarchitecture.domain.doctor.application.port;

import com.course.cleanarchitecture.domain.doctor.model.DoctorEntity;

import java.util.UUID;

public interface GetDoctorByIdProvider {
    DoctorEntity execute(UUID id);
}
