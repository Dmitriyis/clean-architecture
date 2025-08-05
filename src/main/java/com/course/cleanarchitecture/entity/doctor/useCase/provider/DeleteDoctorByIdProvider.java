package com.course.cleanarchitecture.entity.doctor.useCase.provider;

import java.util.UUID;

public interface DeleteDoctorByIdProvider {
    UUID execute(UUID id);
}
