package com.course.cleanarchitecture.entity.pet.useCase;


import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface CreateNewPetUseCase {
    UUID execute(PetRequestDto petRequestDto);
}
