package com.course.cleanarchitecture.entity.appointment.useCase.impl;

import com.course.cleanarchitecture.entity.appointment.useCase.DeleteAppointmentByIdUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.provider.DeleteAppointmentByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteAppointmentByIdUseCaseImpl implements DeleteAppointmentByIdUseCase {

    private final DeleteAppointmentByIdProvider deleteAppointmentByIdProvider;

    @Override
    public UUID execute(UUID id) {
        return deleteAppointmentByIdProvider.execute(id);
    }
}
