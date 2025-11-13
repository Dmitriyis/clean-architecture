package com.course.cleanarchitecture.domain.transportOrder.service;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.pet.useCase.PetRepository;
import com.course.cleanarchitecture.domain.pet.model.useCase.PetSaveUseCase;
import com.course.cleanarchitecture.domain.transportOrder.service.dto.TransportOrderDto;
import com.course.cleanarchitecture.domain.transportOrder.service.mapper.TransportOrderMapper;

import java.util.UUID;

public class TransportOrderSaveUseCaseImpl implements PetSaveUseCase {

    private PetRepository petRepository;
    private TransportOrderMapper petMapper;

    @Override
    public UUID save(TransportOrderDto petRequestDto) {
        OwnerPetEntity petEntity = petMapper.toPetEntity(petRequestDto);
        return petRepository.save(petEntity);
    }
}
