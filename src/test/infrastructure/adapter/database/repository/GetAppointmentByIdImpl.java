package com.course.cleanarchitecture.core.domain.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.core.domain.appointment.application.port.GetAppointmentByIdPort;
import com.course.cleanarchitecture.core.domain.appointment.model.AppointmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetAppointmentByIdImpl implements GetAppointmentByIdPort {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public Optional<AppointmentEntity> execute(UUID id) {
        return appointmentRepositoryJpa.findById(id);
    }
}
