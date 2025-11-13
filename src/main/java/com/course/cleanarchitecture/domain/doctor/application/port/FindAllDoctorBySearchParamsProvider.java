package com.course.cleanarchitecture.domain.doctor.application.port;

import com.course.cleanarchitecture.domain.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.domain.doctor.application.useCase.dto.DoctorSearchParamsDto;

import java.util.List;

public interface FindAllDoctorBySearchParamsProvider {
    List<DoctorEntity> execute(DoctorSearchParamsDto doctorSearchParamsDto);
}
