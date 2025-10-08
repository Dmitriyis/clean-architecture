package com.course.cleanarchitecture.entity.appointment.adapter.database.repository;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.port.FindAllAppointmentBySearchParamsPort;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.entity.appointment.useCase.mapper.AppointmentMapper;
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
