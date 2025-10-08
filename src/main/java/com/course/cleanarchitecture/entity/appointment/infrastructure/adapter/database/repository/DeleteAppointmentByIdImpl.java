package com.course.cleanarchitecture.entity.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.entity.appointment.application.port.DeleteAppointmentByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeleteAppointmentByIdImpl implements DeleteAppointmentByIdPort {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        appointmentRepositoryJpa.deleteById(id);
        return id;
    }
}
