package com.course.cleanarchitecture.entity.appointment.plugins.database.repository;

import com.course.cleanarchitecture.entity.appointment.useCase.provider.DeleteAppointmentByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeleteAppointmentByIdImpl implements DeleteAppointmentByIdProvider {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        appointmentRepositoryJpa.deleteById(id);
        return id;
    }
}
