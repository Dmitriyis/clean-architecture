package com.course.cleanarchitecture.domain.appointment.application.useCase.mapper;

import com.course.cleanarchitecture.domain.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.domain.appointment.model.GenerateAppointmentEntity;
import com.course.cleanarchitecture.domain.appointment.infrastructure.adapter.database.repository.AppointmentSearchParamsSpecification;
import com.course.cleanarchitecture.domain.appointment.application.useCase.dto.AppointmentRequestDto;
import com.course.cleanarchitecture.domain.appointment.application.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.domain.appointment.application.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.domain.appointment.application.useCase.dto.AppointmentUpdateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentMapper {

    public AppointmentEntity toAppointmentEntity(AppointmentRequestDto appointmentRequestDto, UUID id) {
        return GenerateAppointmentEntity.generate(id, appointmentRequestDto.getPetId(), appointmentRequestDto.getDoctorId());
    }

    public AppointmentEntity toAppointmentEntity(AppointmentUpdateDto appointmentUpdateDto, AppointmentEntity appointmentEntity) {
        AppointmentEntity appointmentEntityUpdate = new AppointmentEntity(appointmentEntity.getId(), appointmentEntity.getPet(), null, appointmentUpdateDto.getCreateDateTime());
        return appointmentEntityUpdate;
    }

    public AppointmentResponseDto toResponseDto(AppointmentEntity appointmentEntity) {
        AppointmentResponseDto appointmentResponseDto = AppointmentResponseDto
                .builder()
                .id(appointmentEntity.getId())
                .petId(appointmentEntity.getPet().getId())
                .createDateTime(appointmentEntity.getCreateDateTime())
                .build();
        return appointmentResponseDto;
    }

    public AppointmentSearchParamsSpecification toAppointmentSearchParamsSpecification(AppointmentSearchParamsDto appointmentSearchParamsDto) {
        return null;
    }
}
