package com.course.cleanarchitecture.entity.ownerPet.useCase.impl;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.CreateNewOwnerPetUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.mapper.OwnerPetMapper;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.SaveOwnerPetProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewOwnerPetUseCaseImpl implements CreateNewOwnerPetUseCase {

    private final SaveOwnerPetProvider saveOwnerPetProvider;
    private final OwnerPetMapper ownerPetMapper;

    public UUID execute(OwnerPetRequestDto ownerPetRequestDto) {
        UUID uuid = UUID.randomUUID();
        OwnerPetEntity petEntity = ownerPetMapper.toPetEntity(ownerPetRequestDto, uuid);
        return saveOwnerPetProvider.execute(petEntity);
    }
}
