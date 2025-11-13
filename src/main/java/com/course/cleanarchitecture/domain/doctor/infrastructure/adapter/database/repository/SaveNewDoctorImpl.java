package com.course.cleanarchitecture.domain.doctor.infrastructure.adapter.database.repository;


import com.course.cleanarchitecture.domain.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.domain.doctor.application.port.CreateNewDoctorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveNewDoctorImpl implements CreateNewDoctorProvider {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public UUID execute(DoctorEntity doctor) {
        return doctorRepositoryJpa.save(doctor).getId();
    }
}
