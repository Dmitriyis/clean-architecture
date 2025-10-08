package com.course.cleanarchitecture.entity.doctor.useCase.mapper;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;

import java.util.UUID;

public interface DoctorMapper {

    DoctorEntity toDoctorEntity(DoctorRequestDto doctorRequestDto,  UUID id);

    DoctorEntity toDoctorEntity(DoctorUpdateDto doctorUpdateDto);

    DoctorResponseDto toDoctorRequestDto(DoctorEntity doctorEntity);
}
