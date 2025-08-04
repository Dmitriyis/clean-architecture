package com.course.cleanarchitecture.entity.appointment.useCase;

import java.util.UUID;

public interface DeleteAppointmentByIdUseCase {
    UUID execute(UUID id);
}
