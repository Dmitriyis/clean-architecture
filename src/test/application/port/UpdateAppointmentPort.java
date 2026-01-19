package com.course.cleanarchitecture.core.domain.appointment.application.port;


import com.course.cleanarchitecture.core.domain.appointment.model.AppointmentEntity;

import java.util.UUID;

public interface UpdateAppointmentPort {
    UUID execute(AppointmentEntity appointmentEntity);
}
