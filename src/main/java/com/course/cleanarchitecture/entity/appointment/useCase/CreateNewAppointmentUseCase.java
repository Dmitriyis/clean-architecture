package com.course.cleanarchitecture.entity.appointment.useCase;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.port.SaveAppointmentPort;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentRequestDto;
import com.course.cleanarchitecture.entity.appointment.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import com.course.cleanarchitecture.entity.pet.port.GetPetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewAppointmentUseCase {

    private final GetPetByIdPort getPetByIdPort;
    private final AppointmentMapper appointmentMapper;
    private final SaveAppointmentPort saveAppointmentPort;

    public UUID execute(AppointmentRequestDto appointmentRequestDto) {
        UUID uuid = UUID.randomUUID();

        checkExistPetEntity(appointmentRequestDto);

        AppointmentEntity appointmentEntity = appointmentMapper.toAppointmentEntity(appointmentRequestDto, uuid);
        return saveAppointmentPort.execute(appointmentEntity);
    }

    private void checkExistPetEntity(AppointmentRequestDto appointmentRequestDto) {
        getPetByIdPort.execute(appointmentRequestDto.getPetId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("PetEntity", "id", appointmentRequestDto.getPetId().toString());
                    return new PetNotFoundException(message);
                });
    }
}
