package com.course.cleanarchitecture.entity.appointment.application.useCase;

import com.course.cleanarchitecture.entity.appointment.application.port.DeleteAppointmentByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteAppointmentByIdUseCase {

    private final DeleteAppointmentByIdPort deleteAppointmentByIdPort;


    public UUID execute(UUID id) {
        return deleteAppointmentByIdPort.execute(id);
    }
}
