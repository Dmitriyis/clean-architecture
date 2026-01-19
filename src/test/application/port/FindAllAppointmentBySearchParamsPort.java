package com.course.cleanarchitecture.core.domain.appointment.application.port;

import com.course.cleanarchitecture.core.domain.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.core.domain.appointment.application.useCase.dto.AppointmentSearchParamsDto;

import java.util.List;

public interface FindAllAppointmentBySearchParamsPort {
    List<AppointmentEntity> execute(AppointmentSearchParamsDto appointmentSearchParamsDto);
}
