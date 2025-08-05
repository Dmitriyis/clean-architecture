package com.course.cleanarchitecture.entity.analysis.useCase.provider;

import java.util.UUID;

public interface DeleteDoctorByIdProvider {
    UUID execute(UUID id);
}
