package com.course.cleanarchitecture.entity.analysis.useCase;

import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;

import java.util.List;

public interface FindAllDoctorBySearchParamsUseCase {
    List<DoctorResponseDto> execute(DoctorSearchParamsDto doctorSearchParamsDto);
}
