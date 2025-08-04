package com.course.cleanarchitecture.entity.medicalRecord.model.useCase;

import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface SavePetUseCase {
    UUID save(PetRequestDto petRequestDto);
}
