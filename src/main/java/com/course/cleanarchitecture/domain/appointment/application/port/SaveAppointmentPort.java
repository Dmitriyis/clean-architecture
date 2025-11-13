package com.course.cleanarchitecture.domain.appointment.application.port;


import com.course.cleanarchitecture.domain.appointment.model.AppointmentEntity;

import java.util.UUID;

public interface SaveAppointmentPort {
    UUID execute(AppointmentEntity appointmentEntity);
}
