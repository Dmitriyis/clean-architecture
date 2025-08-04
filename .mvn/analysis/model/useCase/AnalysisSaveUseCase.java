package com.course.cleanarchitecture.entity.analysis.model.useCase;

import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface AnalysisSaveUseCase {
    UUID save(PetRequestDto petRequestDto);
}
