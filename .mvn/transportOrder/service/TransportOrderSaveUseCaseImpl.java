package com.course.cleanarchitecture.entity.transportOrder.service;

import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.PetRepository;
import com.course.cleanarchitecture.entity.pet.model.useCase.PetSaveUseCase;
import com.course.cleanarchitecture.entity.transportOrder.service.dto.TransportOrderDto;
import com.course.cleanarchitecture.entity.transportOrder.service.mapper.TransportOrderMapper;

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
