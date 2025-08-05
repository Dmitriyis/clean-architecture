package com.course.cleanarchitecture.entity.analysis.useCase;

import java.util.UUID;

public interface DeleteDoctorByIdUseCase {
    UUID execute(UUID id);
}
