package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.UpdateDoctorProvider;
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
