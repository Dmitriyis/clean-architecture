package com.course.cleanarchitecture.entity.doctor.adapter.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.port.GetDoctorByIdProvider;
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
