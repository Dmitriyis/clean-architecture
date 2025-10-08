package com.course.cleanarchitecture.entity.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.application.port.GetAppointmentByIdPort;
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
