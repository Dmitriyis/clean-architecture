package com.course.cleanarchitecture.entity.appointment.plugins.database.repository;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.entity.appointment.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.FindAllAppointmentBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllAppointmentBySearchParamsImpl implements FindAllAppointmentBySearchParamsProvider {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public List<AppointmentEntity> execute(AppointmentSearchParamsDto appointmentSearchParamsDto) {
        AppointmentSearchParamsSpecification searchParamsAppointment = appointmentMapper.toAppointmentSearchParamsSpecification(appointmentSearchParamsDto);
        return appointmentRepositoryJpa.findAll(searchParamsAppointment);
    }
}
