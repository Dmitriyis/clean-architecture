package com.course.cleanarchitecture.entity.analysis.useCase.useCaseImpl;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.analysis.exceptions.AnalysisNotFoundException;
import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.UpdateAnalysisUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisUpdateDto;
import com.course.cleanarchitecture.entity.analysis.useCase.mapper.AnalysisMapper;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.GetAnalysisByIdProvider;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.UpdateAnalysisProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateAnalysisImpl implements UpdateAnalysisUseCase {

    private final AnalysisMapper analysisMapper;
    private final UpdateAnalysisProvider updateAnalysisProvider;
    private final GetAnalysisByIdProvider getAnalysisByIdProvider;

    @Override
    public UUID execute(AnalysisUpdateDto analysisUpdateDto) {
        AnalysisEntity analysisEntityFromDataBase = getAnalysisByIdProvider.execute(analysisUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("DoctorEntity", "id", analysisUpdateDto.getId().toString());
                    return new AnalysisNotFoundException(message);
                });

        AnalysisEntity analysisEntity = analysisMapper.toAnalysisEntity(analysisUpdateDto, analysisEntityFromDataBase);

        return updateAnalysisProvider.execute(analysisEntity);
    }
}
