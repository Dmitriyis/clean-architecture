package com.course.cleanarchitecture.entity.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.application.port.FindAllAppointmentBySearchParamsPort;
import com.course.cleanarchitecture.entity.appointment.application.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.entity.appointment.application.useCase.mapper.AppointmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllAppointmentBySearchParamsImpl implements FindAllAppointmentBySearchParamsPort {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public List<AppointmentEntity> execute(AppointmentSearchParamsDto appointmentSearchParamsDto) {
        AppointmentSearchParamsSpecification searchParamsAppointment = appointmentMapper.toAppointmentSearchParamsSpecification(appointmentSearchParamsDto);
        return appointmentRepositoryJpa.findAll(searchParamsAppointment);
    }
}
