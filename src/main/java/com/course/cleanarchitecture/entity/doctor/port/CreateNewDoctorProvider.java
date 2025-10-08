package com.course.cleanarchitecture.entity.doctor.port;


import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;

import java.util.UUID;

public interface CreateNewDoctorProvider {
    UUID execute(DoctorEntity doctor);
}
