package com.course.cleanarchitecture.domain.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.domain.appointment.application.port.GetAppointmentByIdPort;
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
