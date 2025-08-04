package com.course.cleanarchitecture.entity.appointment.plugins.database.repository;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.GetAppointmentByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetAppointmentByIdImpl implements GetAppointmentByIdProvider {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public Optional<AppointmentEntity> execute(UUID id) {
        return appointmentRepositoryJpa.findById(id);
    }
}
