package com.course.cleanarchitecture.entity.appointment.useCase.mapper;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.plugins.database.repository.AppointmentSearchParamsSpecification;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentRequestDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentUpdateDto;

import java.util.UUID;

public interface AppointmentMapper {
    AppointmentEntity toAppointmentEntity(AppointmentRequestDto appointmentRequestDto, UUID id);

    AppointmentEntity toAppointmentEntity(AppointmentUpdateDto appointmentUpdateDto, AppointmentEntity appointmentEntity);

    AppointmentResponseDto toResponseDto(AppointmentEntity appointmentEntity);

    AppointmentSearchParamsSpecification toAppointmentSearchParamsSpecification(AppointmentSearchParamsDto appointmentSearchParamsDto);
}
