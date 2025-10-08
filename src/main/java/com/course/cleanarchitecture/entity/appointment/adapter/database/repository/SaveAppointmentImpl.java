package com.course.cleanarchitecture.entity.appointment.adapter.database.repository;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.port.SaveAppointmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SaveAppointmentImpl implements SaveAppointmentPort {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public UUID execute(AppointmentEntity appointmentEntity) {
        return appointmentRepositoryJpa.save(appointmentEntity).getId();
    }
}
