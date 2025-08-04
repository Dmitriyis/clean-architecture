package com.course.cleanarchitecture.entity.appointment.useCase.provider;

import java.util.UUID;

public interface DeleteAppointmentByIdProvider {
    UUID execute(UUID id);
}
