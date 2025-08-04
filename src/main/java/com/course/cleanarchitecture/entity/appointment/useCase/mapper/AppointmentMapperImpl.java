package com.course.cleanarchitecture.entity.appointment.useCase.mapper;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.model.GenerateAppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.plugins.database.repository.AppointmentSearchParamsSpecification;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentRequestDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentUpdateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentEntity toAppointmentEntity(AppointmentRequestDto appointmentRequestDto, UUID id) {
        return GenerateAppointmentEntity.generate(id, appointmentRequestDto.getPetId());
    }

    @Override
    public AppointmentEntity toAppointmentEntity(AppointmentUpdateDto appointmentUpdateDto, AppointmentEntity appointmentEntity) {
        AppointmentEntity appointmentEntityUpdate = new AppointmentEntity(appointmentEntity.getId(), appointmentEntity.getPet(), appointmentUpdateDto.getCreateDateTime());
        return appointmentEntityUpdate;
    }

    @Override
    public AppointmentResponseDto toResponseDto(AppointmentEntity appointmentEntity) {
        AppointmentResponseDto appointmentResponseDto = AppointmentResponseDto
                .builder()
                .id(appointmentEntity.getId())
                .petId(appointmentEntity.getPet().getId())
                .createDateTime(appointmentEntity.getCreateDateTime())
                .build();
        return appointmentResponseDto;
    }

    @Override
    public AppointmentSearchParamsSpecification toAppointmentSearchParamsSpecification(AppointmentSearchParamsDto appointmentSearchParamsDto) {
        return null;
    }
}
