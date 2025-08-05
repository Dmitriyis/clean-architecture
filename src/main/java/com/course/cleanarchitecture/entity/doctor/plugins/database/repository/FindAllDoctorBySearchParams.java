package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.FindAllDoctorBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllDoctorBySearchParams implements FindAllDoctorBySearchParamsProvider {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public List<DoctorEntity> execute(DoctorSearchParamsDto doctorSearchParamsDto) {

        DoctorSearchParamsSpecification doctorSearchParamsSpecification = toDoctorSearchParamsSpecification(doctorSearchParamsDto);

        return doctorRepositoryJpa.findAll(doctorSearchParamsSpecification);
    }


    public DoctorSearchParamsSpecification toDoctorSearchParamsSpecification(DoctorSearchParamsDto doctorSearchParamsDto) {
        return DoctorSearchParamsSpecification
                .builder()
                .id(doctorSearchParamsDto.getId())
                .name(doctorSearchParamsDto.getName())
                .profession(doctorSearchParamsDto.getProfession())
                .workExperience(doctorSearchParamsDto.getWorkExperience())
                .build();
    }
}
