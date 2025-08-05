package com.course.cleanarchitecture.entity.appointment.useCase.useCaseImpl;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.appointment.useCase.FindAllAppointmentBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentSearchParamsDto;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.FindAllAppointmentBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllAppointmentBySearchParamsUseCaseImpl implements FindAllAppointmentBySearchParamsUseCase {

  private final FindAllAppointmentBySearchParamsProvider findAllAppointmentBySearchParamsProvider;

    @Override
    public List<AppointmentEntity> execute(AppointmentSearchParamsDto appointmentSearchParamsDto) {
        return findAllAppointmentBySearchParamsProvider.execute(appointmentSearchParamsDto);
    }
}
