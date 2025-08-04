package com.course.cleanarchitecture.entity.appointment.plugins.database.repository;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.SaveAppointmentProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SaveAppointmentImpl implements SaveAppointmentProvider {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public UUID execute(AppointmentEntity appointmentEntity) {
        return appointmentRepositoryJpa.save(appointmentEntity).getId();
    }
}
