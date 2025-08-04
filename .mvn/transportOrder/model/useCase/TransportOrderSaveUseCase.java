package com.course.cleanarchitecture.entity.transportOrder.model.useCase;

import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface TransportOrderSaveUseCase {
    UUID save(PetRequestDto petRequestDto);
}
