package com.course.cleanarchitecture.entity.doctor.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.entity.doctor.application.port.DeleteDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteDoctorByIdImpl implements DeleteDoctorByIdProvider {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public UUID execute(UUID id) {
        doctorRepositoryJpa.deleteById(id);
        return id;
    }
}
