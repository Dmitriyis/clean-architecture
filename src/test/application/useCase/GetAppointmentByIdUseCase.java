package com.course.cleanarchitecture.core.domain.appointment.application.useCase;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.core.domain.appointment.application.port.GetAppointmentByIdPort;
import com.course.cleanarchitecture.core.domain.appointment.application.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.core.domain.appointment.exceptions.AppointmentNotFoundException;
import com.course.cleanarchitecture.core.domain.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.core.domain.appointment.application.useCase.dto.AppointmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAppointmentByIdUseCase {

    private final AppointmentMapper appointmentMapper;
    private final GetAppointmentByIdPort getAppointmentByIdPort;


    public AppointmentResponseDto execute(UUID id) {
        AppointmentEntity appointmentEntity = getAppointmentByIdPort.execute(id)
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("OwnerPetEntity", "id", id.toString());
                    return new AppointmentNotFoundException(message);
                });

        return appointmentMapper.toResponseDto(appointmentEntity);
    }
}
