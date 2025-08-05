package com.course.cleanarchitecture.entity.analysis.useCase.provider;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;

import java.util.UUID;

public interface UpdateDoctorProvider {
    UUID execute(DoctorEntity doctorEntity);
}
