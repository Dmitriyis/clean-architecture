package com.course.cleanarchitecture.domain.transportOrder.model.useCase;

import com.course.cleanarchitecture.domain.pet.useCase.dto.PetRequestDto;

import java.util.UUID;

public interface TransportOrderSaveUseCase {
    UUID save(PetRequestDto petRequestDto);
}
