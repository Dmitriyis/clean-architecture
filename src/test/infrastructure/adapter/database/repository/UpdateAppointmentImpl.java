package com.course.cleanarchitecture.core.domain.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.core.domain.appointment.application.port.UpdateAppointmentPort;
import com.course.cleanarchitecture.core.domain.appointment.model.AppointmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UpdateAppointmentImpl implements UpdateAppointmentPort {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public UUID execute(AppointmentEntity appointmentEntity) {
        return appointmentRepositoryJpa.save(appointmentEntity).getId();
    }
}
