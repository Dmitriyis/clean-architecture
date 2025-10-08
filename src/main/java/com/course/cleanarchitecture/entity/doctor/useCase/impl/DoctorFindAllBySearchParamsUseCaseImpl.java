package com.course.cleanarchitecture.entity.doctor.useCase.impl;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.FindAllDoctorBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.FindAllDoctorBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorFindAllBySearchParamsUseCaseImpl implements FindAllDoctorBySearchParamsUseCase {

    private final DoctorMapper doctorMapper;
    private final FindAllDoctorBySearchParamsProvider findAllDoctorBySearchParamsProvider;

    @Override
    public List<DoctorResponseDto> execute(DoctorSearchParamsDto doctorSearchParamsDto) {
        List<DoctorEntity> doctors = findAllDoctorBySearchParamsProvider.execute(doctorSearchParamsDto);
        return doctors.stream().map(doctorMapper::toDoctorRequestDto).toList();
    }
}
