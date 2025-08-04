package com.course.cleanarchitecture.entity.doctor.useCase;

import java.util.UUID;

public interface DeleteDoctorByIdUseCase {
    UUID execute(UUID id);
}
