package com.course.cleanarchitecture.entity.appointment.port;

import java.util.UUID;

public interface DeleteAppointmentByIdPort {
    UUID execute(UUID id);
}
