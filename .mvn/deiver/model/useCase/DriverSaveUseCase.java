package com.course.cleanarchitecture.domain.deiver.model.useCase;

import com.course.cleanarchitecture.domain.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface DriverSaveUseCase {
    UUID save(PetRequestDto petRequestDto);
}
