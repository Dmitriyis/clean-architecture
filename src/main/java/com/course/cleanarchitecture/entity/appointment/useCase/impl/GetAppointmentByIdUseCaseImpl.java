package com.course.cleanarchitecture.entity.appointment.useCase.impl;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.appointment.exceptions.AppointmentNotFoundException;
import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.GetAppointmentByIdUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.entity.appointment.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.GetAppointmentByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAppointmentByIdUseCaseImpl implements GetAppointmentByIdUseCase {

    private final AppointmentMapper appointmentMapper;
    private final GetAppointmentByIdProvider getAppointmentByIdProvider;

    @Override
    public AppointmentResponseDto execute(UUID id) {
        AppointmentEntity appointmentEntity = getAppointmentByIdProvider.execute(id)
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("OwnerPetEntity", "id", id.toString());
                    return new AppointmentNotFoundException(message);
                });

        return appointmentMapper.toResponseDto(appointmentEntity);
    }
}
