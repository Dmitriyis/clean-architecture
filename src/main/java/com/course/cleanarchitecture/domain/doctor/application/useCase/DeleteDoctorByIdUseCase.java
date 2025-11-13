package com.course.cleanarchitecture.domain.doctor.application.useCase;

import com.course.cleanarchitecture.domain.doctor.application.port.DeleteDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteDoctorByIdUseCase {

    private final DeleteDoctorByIdProvider deleteDoctorByIdProvider;


    public UUID execute(UUID id) {
        return deleteDoctorByIdProvider.execute(id);
    }
}
