package com.course.cleanarchitecture.entity.doctor.useCase.impl;

import com.course.cleanarchitecture.entity.doctor.useCase.DeleteDoctorByIdUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.DeleteDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteDoctorByIdUseCaseImpl implements DeleteDoctorByIdUseCase {

    private final DeleteDoctorByIdProvider deleteDoctorByIdProvider;

    @Override
    public UUID execute(UUID id) {
        return deleteDoctorByIdProvider.execute(id);
    }
}
