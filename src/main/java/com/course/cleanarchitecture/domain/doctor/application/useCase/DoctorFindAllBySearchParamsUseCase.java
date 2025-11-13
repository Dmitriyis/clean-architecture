package com.course.cleanarchitecture.domain.doctor.application.useCase;

import com.course.cleanarchitecture.domain.doctor.application.port.FindAllDoctorBySearchParamsProvider;
import com.course.cleanarchitecture.domain.doctor.application.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.domain.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.domain.doctor.application.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.domain.doctor.application.useCase.dto.DoctorSearchParamsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorFindAllBySearchParamsUseCase {

    private final DoctorMapper doctorMapper;
    private final FindAllDoctorBySearchParamsProvider findAllDoctorBySearchParamsProvider;


    public List<DoctorResponseDto> execute(DoctorSearchParamsDto doctorSearchParamsDto) {
        List<DoctorEntity> doctors = findAllDoctorBySearchParamsProvider.execute(doctorSearchParamsDto);
        return doctors.stream().map(doctorMapper::toDoctorRequestDto).toList();
    }
}
