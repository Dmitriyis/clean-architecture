package com.course.cleanarchitecture.entity.analysis.useCase.useCaseImpl;

import com.course.cleanarchitecture.entity.analysis.useCase.FindAllAnalysisBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisResponseDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisSearchParamsDto;
import com.course.cleanarchitecture.entity.analysis.useCase.mapper.AnalysisMapper;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.FindAllAnalysisBySearchParamsProvider;
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
public class FindAllAnalysisBySearchParamsImpl implements FindAllAnalysisBySearchParamsUseCase {

    private final AnalysisMapper analysisMapper;
    private final FindAllAnalysisBySearchParamsProvider findAllAnalysisBySearchParamsProvider;

    @Override
    public List<AnalysisResponseDto> execute(AnalysisSearchParamsDto analysisSearchParamsDto) {
        return findAllAnalysisBySearchParamsProvider.execute(analysisSearchParamsDto)
                .stream()
                .map(analysisMapper::toAnalysisResponseDto)
                .toList();
    }
}
