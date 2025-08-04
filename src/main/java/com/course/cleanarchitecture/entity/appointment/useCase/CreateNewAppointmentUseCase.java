package com.course.cleanarchitecture.entity.appointment.useCase;


import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentRequestDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetRequestDto;

import java.util.UUID;

public interface CreateNewAppointmentUseCase {
    UUID execute(AppointmentRequestDto appointmentRequestDto);
}
