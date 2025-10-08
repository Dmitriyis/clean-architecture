package com.course.cleanarchitecture.entity.doctor.application.port;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.application.useCase.dto.DoctorSearchParamsDto;

import java.util.List;

public interface FindAllDoctorBySearchParamsProvider {
    List<DoctorEntity> execute(DoctorSearchParamsDto doctorSearchParamsDto);
}
