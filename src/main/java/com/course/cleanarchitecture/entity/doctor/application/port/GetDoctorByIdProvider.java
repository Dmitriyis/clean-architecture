package com.course.cleanarchitecture.entity.doctor.application.port;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;

import java.util.UUID;

public interface GetDoctorByIdProvider {
    DoctorEntity execute(UUID id);
}
