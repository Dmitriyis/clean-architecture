package com.course.cleanarchitecture.entity.appointment.application.port;


import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.UUID;

public interface SaveAppointmentPort {
    UUID execute(AppointmentEntity appointmentEntity);
}
