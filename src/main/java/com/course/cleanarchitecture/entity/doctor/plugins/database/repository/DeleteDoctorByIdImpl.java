package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;

import com.course.cleanarchitecture.entity.doctor.useCase.provider.DeleteDoctorByIdProvider;
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
