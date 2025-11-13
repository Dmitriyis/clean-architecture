package com.course.cleanarchitecture.domain.appointment.application.useCase;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.domain.appointment.application.port.GetAppointmentByIdPort;
import com.course.cleanarchitecture.domain.appointment.application.port.UpdateAppointmentPort;
import com.course.cleanarchitecture.domain.appointment.application.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.domain.appointment.exceptions.AppointmentNotFoundException;
import com.course.cleanarchitecture.domain.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.domain.appointment.application.useCase.dto.AppointmentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateAppointmentUseCase {

    private final AppointmentMapper appointmentMapper;
    private final UpdateAppointmentPort updateAppointmentPot;
    private final GetAppointmentByIdPort getAppointmentByIPort;

    public UUID execute(AppointmentUpdateDto appointmentUpdateDto) {
        AppointmentEntity appointmentEntityFromDataBase = getAppointmentByIPort.execute(appointmentUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("OwnerPetEntity", "id", appointmentUpdateDto.getId().toString());
                    return new AppointmentNotFoundException(message);
                });

        AppointmentEntity appointmentEntity = appointmentMapper.toAppointmentEntity(appointmentUpdateDto, appointmentEntityFromDataBase);

        return updateAppointmentPot.execute(appointmentEntity);
    }
}
