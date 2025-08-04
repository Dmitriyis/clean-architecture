package com.course.cleanarchitecture.entity.deiver.model.useCase;

import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface DriverSaveUseCase {
    UUID save(PetRequestDto petRequestDto);
}
