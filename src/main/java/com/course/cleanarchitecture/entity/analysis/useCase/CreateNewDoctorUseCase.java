package com.course.cleanarchitecture.entity.analysis.useCase;


import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;

import java.util.UUID;

public interface CreateNewDoctorUseCase {
    UUID execute(DoctorRequestDto doctorRequestDto);
}
