package com.course.cleanarchitecture.entity.doctor.application.useCase.mapper;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.application.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.application.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.application.useCase.dto.DoctorUpdateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorMapper{

    public DoctorEntity toDoctorEntity(DoctorRequestDto doctorRequestDto, UUID id) {
        DoctorEntity doctorEntity = new DoctorEntity(id, doctorRequestDto.getName(), doctorRequestDto.getProfession(), doctorRequestDto.getWorkExperience(), null);

        return doctorEntity;
    }

    public DoctorEntity toDoctorEntity(DoctorUpdateDto doctorUpdateDto) {
        DoctorEntity doctorEntity = new DoctorEntity(doctorUpdateDto.getId(), doctorUpdateDto.getName(), doctorUpdateDto.getProfession(), doctorUpdateDto.getWorkExperience(), null);

        return doctorEntity;
    }

    public DoctorResponseDto toDoctorRequestDto(DoctorEntity doctorEntity) {
        DoctorResponseDto doctorRequestDto = DoctorResponseDto
                .builder()
                .id(doctorEntity.getId())
                .name(doctorEntity.getName())
                .profession(doctorEntity.getProfession())
                .workExperience(doctorEntity.getWorkExperience())
                .build();
        return doctorRequestDto;
    }
}
