package com.course.cleanarchitecture.entity.appointment.application.port;


import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetAppointmentByIdPort {
    Optional<AppointmentEntity> execute(UUID id);
}
