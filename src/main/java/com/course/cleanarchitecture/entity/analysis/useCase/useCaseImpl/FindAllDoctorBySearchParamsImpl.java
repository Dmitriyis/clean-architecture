package com.course.cleanarchitecture.entity.analysis.useCase.useCaseImpl;

import com.course.cleanarchitecture.entity.doctor.useCase.FindAllDoctorBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorSearchParamsDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.FindAllDoctorBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllDoctorBySearchParamsImpl implements FindAllDoctorBySearchParamsUseCase {

    private final DoctorMapper doctorMapper;
    private final FindAllDoctorBySearchParamsProvider findAllDoctorBySearchParamsProvider;

    @Override
    public List<DoctorResponseDto> execute(DoctorSearchParamsDto doctorSearchParamsDto) {
        return findAllDoctorBySearchParamsProvider.execute(doctorSearchParamsDto)
                .stream()
                .map(doctorMapper::toDoctorResponseDto)
                .toList();
    }
}
