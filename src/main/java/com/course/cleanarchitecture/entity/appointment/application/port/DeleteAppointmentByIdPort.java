package com.course.cleanarchitecture.entity.appointment.application.port;

import java.util.UUID;

public interface DeleteAppointmentByIdPort {
    UUID execute(UUID id);
}
