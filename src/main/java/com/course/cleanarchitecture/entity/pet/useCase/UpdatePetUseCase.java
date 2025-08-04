package com.course.cleanarchitecture.entity.pet.useCase;

import com.course.cleanarchitecture.entity.pet.useCase.dto.PetUpdateDto;

import java.util.UUID;

public interface UpdatePetUseCase {
    UUID execute(PetUpdateDto petUpdateDto);
}
