package com.course.cleanarchitecture.entity.appointment.useCase;

import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentUpdateDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetUpdateDto;

import java.util.UUID;

public interface UpdateAppointmentUseCase {
    UUID execute(AppointmentUpdateDto appointmentUpdateDto);
}
