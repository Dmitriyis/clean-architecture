package com.course.cleanarchitecture.entity.analysis.useCase.useCaseImpl;

import com.course.cleanarchitecture.entity.analysis.useCase.DeleteAnalysisByIdUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.DeleteAnalysisByIdProvider;
import com.course.cleanarchitecture.entity.doctor.useCase.DeleteDoctorByIdUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.DeleteDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteAnalysisByIdImpl implements DeleteAnalysisByIdUseCase {

    private final DeleteAnalysisByIdProvider deleteAnalysisByIdProvider;

    @Override
    public UUID execute(UUID id) {
        return deleteAnalysisByIdProvider.execute(id);
    }
}
