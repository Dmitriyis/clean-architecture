package com.course.cleanarchitecture.domain.service.model.useCase;

import com.course.cleanarchitecture.domain.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface SavePetUseCase {
    UUID save(PetRequestDto petRequestDto);
}
