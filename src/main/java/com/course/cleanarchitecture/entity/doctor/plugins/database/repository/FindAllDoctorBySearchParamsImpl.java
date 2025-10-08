package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.FindAllDoctorBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllDoctorBySearchParamsImpl implements FindAllDoctorBySearchParamsProvider {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public List<DoctorEntity> execute(DoctorSearchParamsDto doctorSearchParamsDto) {
        DoctorSearchParamsSpecification doctorSearchParamsSpecification = toPetSearchParamsInfra(doctorSearchParamsDto);

        return doctorRepositoryJpa.findAll(doctorSearchParamsSpecification);
    }

    private DoctorSearchParamsSpecification toPetSearchParamsInfra(DoctorSearchParamsDto doctorSearchParamsDto) {
        DoctorSearchParamsSpecification doctorSearchParamsSpecification = DoctorSearchParamsSpecification
                .builder()
                .name(doctorSearchParamsDto.getName())
                .build();

        return doctorSearchParamsSpecification;
    }
}
