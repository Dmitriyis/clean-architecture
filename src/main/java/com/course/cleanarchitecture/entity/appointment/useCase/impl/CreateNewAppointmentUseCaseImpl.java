package com.course.cleanarchitecture.entity.appointment.useCase.impl;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.CreateNewAppointmentUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentRequestDto;
import com.course.cleanarchitecture.entity.appointment.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.SaveAppointmentProvider;
import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import com.course.cleanarchitecture.entity.pet.port.GetPetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewAppointmentUseCaseImpl implements CreateNewAppointmentUseCase {

    private final GetPetByIdPort getPetByIdPort;
    private final AppointmentMapper appointmentMapper;
    private final SaveAppointmentProvider saveAppointmentProvider;

    public UUID execute(AppointmentRequestDto appointmentRequestDto) {
        UUID uuid = UUID.randomUUID();

        checkExistPetEntity(appointmentRequestDto);

        AppointmentEntity appointmentEntity = appointmentMapper.toAppointmentEntity(appointmentRequestDto, uuid);
        return saveAppointmentProvider.execute(appointmentEntity);
    }

    private void checkExistPetEntity(AppointmentRequestDto appointmentRequestDto) {
        getPetByIdPort.execute(appointmentRequestDto.getPetId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("PetEntity", "id", appointmentRequestDto.getPetId().toString());
                    return new PetNotFoundException(message);
                });
    }
}
