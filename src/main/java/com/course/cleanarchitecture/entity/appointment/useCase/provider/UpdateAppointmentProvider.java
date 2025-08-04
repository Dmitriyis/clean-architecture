package com.course.cleanarchitecture.entity.appointment.useCase.provider;


import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.UUID;

public interface UpdateAppointmentProvider {
    UUID execute(AppointmentEntity appointmentEntity);
}
