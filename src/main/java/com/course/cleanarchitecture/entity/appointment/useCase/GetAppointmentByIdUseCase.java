package com.course.cleanarchitecture.entity.appointment.useCase;


import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentResponseDto;

import java.util.UUID;

public interface GetAppointmentByIdUseCase {
    AppointmentResponseDto execute(UUID id);
}
