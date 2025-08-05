package com.course.cleanarchitecture.entity.doctor.useCase.useCaseImpl;


import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.CreateNewDoctorUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.SaveDoctorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewDoctorImpl implements CreateNewDoctorUseCase {

    private final DoctorMapper doctorMapper;
    private final SaveDoctorProvider saveDoctorProvider;

    @Override
    public UUID execute(DoctorRequestDto doctorRequestDto) {
        UUID id = UUID.randomUUID();
        DoctorEntity doctorEntity = doctorMapper.toDoctorEntity(doctorRequestDto, id);
        return saveDoctorProvider.execute(doctorEntity);
    }
}
