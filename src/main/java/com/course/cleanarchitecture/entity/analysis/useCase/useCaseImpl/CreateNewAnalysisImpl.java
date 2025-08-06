package com.course.cleanarchitecture.entity.analysis.useCase.useCaseImpl;


import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.CreateNewAnalysisUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisRequestDto;
import com.course.cleanarchitecture.entity.analysis.useCase.mapper.AnalysisMapper;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.SaveAnalysisProvider;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.CreateNewDoctorUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.SaveDoctorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewAnalysisImpl implements CreateNewAnalysisUseCase {

    private final AnalysisMapper analysisMapper;
    private final SaveAnalysisProvider saveAnalysisProvider;

    @Override
    public UUID execute(AnalysisRequestDto analysisRequestDto) {
        UUID id = UUID.randomUUID();
        AnalysisEntity analysisEntity = analysisMapper.toAnalysisEntity(analysisRequestDto, id);
        return saveAnalysisProvider.execute(analysisEntity);
    }
}
