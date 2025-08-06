package com.course.cleanarchitecture.entity.analysis.useCase.useCaseImpl;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.analysis.exceptions.AnalysisNotFoundException;
import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.GetAnalysisByIdUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisResponseDto;
import com.course.cleanarchitecture.entity.analysis.useCase.mapper.AnalysisMapper;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.GetAnalysisByIdProvider;
import com.course.cleanarchitecture.entity.doctor.exceptions.DoctorNotFoundException;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.GetDoctorByIdUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.GetDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAnalysisByIdImpl implements GetAnalysisByIdUseCase {

    private final AnalysisMapper analysisMapper;
    private final GetAnalysisByIdProvider getAnalysisByIdProvider;

    @Override
    public AnalysisResponseDto execute(UUID id) {
        AnalysisEntity analysisEntity = getAnalysisByIdProvider.execute(id)
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("DoctorEntity", "id", id.toString());
                    return new AnalysisNotFoundException(message);
                });

        return analysisMapper.toAnalysisResponseDto(analysisEntity);
    }
}
