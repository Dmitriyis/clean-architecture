package com.course.cleanarchitecture.core.domain.appointment.application.port;


import com.course.cleanarchitecture.core.domain.appointment.model.AppointmentEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetAppointmentByIdPort {
    Optional<AppointmentEntity> execute(UUID id);
}
