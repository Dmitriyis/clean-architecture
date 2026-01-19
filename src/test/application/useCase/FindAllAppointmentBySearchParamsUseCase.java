package com.course.cleanarchitecture.core.domain.appointment.application.useCase;

import com.course.cleanarchitecture.core.domain.appointment.application.port.FindAllAppointmentBySearchParamsPort;
import com.course.cleanarchitecture.core.domain.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.core.domain.appointment.application.useCase.dto.AppointmentSearchParamsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllAppointmentBySearchParamsUseCase {

    private final FindAllAppointmentBySearchParamsPort findAllAppointmentBySearchParamPort;


    public List<AppointmentEntity> execute(AppointmentSearchParamsDto appointmentSearchParamsDto) {
        return findAllAppointmentBySearchParamPort.execute(appointmentSearchParamsDto);
    }
}
