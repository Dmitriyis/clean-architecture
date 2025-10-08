package com.course.cleanarchitecture.entity.doctor.useCase;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.port.FindAllDoctorBySearchParamsProvider;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
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
