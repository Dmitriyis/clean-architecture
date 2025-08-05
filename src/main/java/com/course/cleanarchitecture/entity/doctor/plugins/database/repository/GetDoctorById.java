package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.GetDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetDoctorById implements GetDoctorByIdProvider {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public Optional<DoctorEntity> execute(UUID id) {
        return doctorRepositoryJpa.findById(id);
    }
}
