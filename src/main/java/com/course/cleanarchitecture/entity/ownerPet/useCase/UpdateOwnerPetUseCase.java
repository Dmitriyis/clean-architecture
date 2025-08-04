package com.course.cleanarchitecture.entity.ownerPet.useCase;

import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetUpdateDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetUpdateDto;

import java.util.UUID;

public interface UpdateOwnerPetUseCase {
    UUID execute(OwnerPetUpdateDto ownerPetUpdateDto);
}
