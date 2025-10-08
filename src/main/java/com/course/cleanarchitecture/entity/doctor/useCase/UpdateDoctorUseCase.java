package com.course.cleanarchitecture.entity.doctor.useCase;

import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;

import java.util.UUID;

public interface UpdateDoctorUseCase {
    UUID execute(DoctorUpdateDto doctorUpdateDto);
}
