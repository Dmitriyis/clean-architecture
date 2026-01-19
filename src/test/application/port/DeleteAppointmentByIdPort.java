package com.course.cleanarchitecture.core.domain.appointment.application.port;

import java.util.UUID;

public interface DeleteAppointmentByIdPort {
    UUID execute(UUID id);
}
