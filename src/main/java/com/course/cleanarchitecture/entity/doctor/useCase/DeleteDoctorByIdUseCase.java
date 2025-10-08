package com.course.cleanarchitecture.entity.doctor.useCase;

import com.course.cleanarchitecture.entity.doctor.port.DeleteDoctorByIdProvider;
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
