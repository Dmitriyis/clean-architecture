package com.course.cleanarchitecture.entity.analysis.useCase.provider;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;

import java.util.UUID;

public interface SaveDoctorProvider {
    UUID execute(DoctorEntity doctorEntity);
}
