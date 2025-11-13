package com.course.cleanarchitecture.domain.analysis.model.useCase;

import com.course.cleanarchitecture.domain.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface AnalysisSaveUseCase {
    UUID save(PetRequestDto petRequestDto);
}
