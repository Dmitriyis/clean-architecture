package com.course.cleanarchitecture.entity.appointment.model;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class GenerateAppointmentEntity {

    public static AppointmentEntity generate(UUID id, UUID petId, UUID doctorId) {
        PetEntity petEntity = new PetEntity(petId, null, null, null, null, null, null, null);
        DoctorEntity doctorEntity = new DoctorEntity(doctorId, null, null, null, null);

        AppointmentEntity appointmentEntity = new AppointmentEntity(id, petEntity, doctorEntity, LocalDateTime.now());
        return appointmentEntity;
    }
}
