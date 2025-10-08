package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;


import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.CreateNewDoctorProvider;
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
