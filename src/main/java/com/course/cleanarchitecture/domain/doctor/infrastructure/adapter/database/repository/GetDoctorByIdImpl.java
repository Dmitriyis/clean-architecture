package com.course.cleanarchitecture.domain.doctor.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.domain.doctor.application.port.GetDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetDoctorByIdImpl implements GetDoctorByIdProvider {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public DoctorEntity execute(UUID id) {
        return doctorRepositoryJpa.getReferenceById(id);
    }
}
