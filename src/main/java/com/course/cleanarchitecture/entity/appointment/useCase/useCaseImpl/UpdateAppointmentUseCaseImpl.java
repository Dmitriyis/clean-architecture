package com.course.cleanarchitecture.entity.appointment.useCase.useCaseImpl;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.appointment.exceptions.AppointmentNotFoundException;
import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.UpdateAppointmentUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentUpdateDto;
import com.course.cleanarchitecture.entity.appointment.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.GetAppointmentByIdProvider;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.UpdateAppointmentProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateAppointmentUseCaseImpl implements UpdateAppointmentUseCase {

    private final AppointmentMapper appointmentMapper;
    private final GetAppointmentByIdProvider getAppointmentByIdProvider;
    private final UpdateAppointmentProvider updateAppointmentProvider;

    @Override
    public UUID execute(AppointmentUpdateDto appointmentUpdateDto) {
        AppointmentEntity appointmentEntityFromDataBase = getAppointmentByIdProvider.execute(appointmentUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("OwnerPetEntity", "id", appointmentUpdateDto.getId().toString());
                    return new AppointmentNotFoundException(message);
                });

        AppointmentEntity appointmentEntity = appointmentMapper.toAppointmentEntity(appointmentUpdateDto, appointmentEntityFromDataBase);

        return updateAppointmentProvider.execute(appointmentEntity);
    }
}
