package com.course.cleanarchitecture.entity.doctor.useCase.provider;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;

import java.util.List;

public interface FindAllDoctorBySearchParamsProvider {

    List<DoctorEntity> execute(DoctorSearchParamsDto doctorSearchParamsDto);
}
