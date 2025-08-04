package com.course.cleanarchitecture.entity.ownerPet.useCase;


import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface CreateNewOwnerPetUseCase {
    UUID execute(OwnerPetRequestDto ownerPetRequestDto);
}
