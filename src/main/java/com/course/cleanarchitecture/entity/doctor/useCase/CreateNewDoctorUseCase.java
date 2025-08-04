package com.course.cleanarchitecture.entity.doctor.useCase;


import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface CreateNewDoctorUseCase {
    UUID execute(DoctorRequestDto doctorRequestDto);
}
