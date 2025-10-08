package com.course.cleanarchitecture.entity.doctor.port;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;

import java.util.UUID;

public interface UpdateDoctorProvider {
    UUID execute(DoctorEntity doctor);
}
