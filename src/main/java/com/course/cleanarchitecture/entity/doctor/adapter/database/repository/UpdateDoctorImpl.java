package com.course.cleanarchitecture.entity.doctor.adapter.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.port.UpdateDoctorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateDoctorImpl implements UpdateDoctorProvider {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public UUID execute(DoctorEntity doctor) {
        return doctorRepositoryJpa.save(doctor).getId();
    }
}
