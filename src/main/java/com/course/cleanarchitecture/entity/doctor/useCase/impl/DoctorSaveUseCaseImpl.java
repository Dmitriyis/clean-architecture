package com.course.cleanarchitecture.entity.doctor.useCase.impl;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.CreateNewDoctorUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.CreateNewDoctorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorSaveUseCaseImpl implements CreateNewDoctorUseCase {


    private final DoctorMapper doctorMapper;
    private final CreateNewDoctorProvider createNewDoctorProvider;

    @Override
    public UUID execute(DoctorRequestDto doctorRequestDto) {
        DoctorEntity doctorEntity = doctorMapper.toDoctorEntity(doctorRequestDto, UUID.randomUUID());

        return createNewDoctorProvider.execute(doctorEntity);
    }
}
