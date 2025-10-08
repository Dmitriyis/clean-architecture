package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.GetDoctorByIdProvider;
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
