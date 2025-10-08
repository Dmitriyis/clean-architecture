package com.course.cleanarchitecture.entity.doctor.application.useCase;

import com.course.cleanarchitecture.entity.doctor.application.port.CreateNewDoctorProvider;
import com.course.cleanarchitecture.entity.doctor.application.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.application.useCase.dto.DoctorRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorSaveUseCase {

    private final DoctorMapper doctorMapper;
    private final CreateNewDoctorProvider createNewDoctorProvider;

    public UUID execute(DoctorRequestDto doctorRequestDto) {
        DoctorEntity doctorEntity = doctorMapper.toDoctorEntity(doctorRequestDto, UUID.randomUUID());

        return createNewDoctorProvider.execute(doctorEntity);
    }
}
