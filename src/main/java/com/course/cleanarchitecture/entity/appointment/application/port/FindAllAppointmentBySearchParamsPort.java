package com.course.cleanarchitecture.entity.appointment.application.port;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.application.useCase.dto.AppointmentSearchParamsDto;

import java.util.List;

public interface FindAllAppointmentBySearchParamsPort {
    List<AppointmentEntity> execute(AppointmentSearchParamsDto appointmentSearchParamsDto);
}
