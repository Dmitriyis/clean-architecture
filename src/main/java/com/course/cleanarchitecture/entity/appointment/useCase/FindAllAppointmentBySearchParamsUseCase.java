package com.course.cleanarchitecture.entity.appointment.useCase;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetSearchParamsDto;

import java.util.List;

public interface FindAllAppointmentBySearchParamsUseCase {
    List<AppointmentEntity> execute(AppointmentSearchParamsDto appointmentSearchParamsDto);
}
