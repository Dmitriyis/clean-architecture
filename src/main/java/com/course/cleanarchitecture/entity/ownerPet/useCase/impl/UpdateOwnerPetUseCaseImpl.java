package com.course.cleanarchitecture.entity.ownerPet.useCase.impl;

import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.UpdateOwnerPetUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetUpdateDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.mapper.OwnerPetMapper;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.GetOwnerPetByIdProvider;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.UpdateOwnerPetProvider;
import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateOwnerPetUseCaseImpl implements UpdateOwnerPetUseCase {

    private final OwnerPetMapper ownerPetMapper;
    private final GetOwnerPetByIdProvider getOwnerPetByIdProvider;
    private final UpdateOwnerPetProvider updateOwnerPetProvider;

    @Override
    public UUID execute(OwnerPetUpdateDto ownerPetUpdateDto) {
        OwnerPetEntity ownerPetEntityFromDataBase = getOwnerPetByIdProvider.execute(ownerPetUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = PetNotFoundException.prepareMessage("OwnerPetEntity", "id", ownerPetUpdateDto.getId().toString());
                    return new OwnerPetNotFoundException(message);
                });

        OwnerPetEntity ownerPetEntity = ownerPetMapper.toPetEntity(ownerPetUpdateDto, ownerPetEntityFromDataBase);

        return updateOwnerPetProvider.execute(ownerPetEntity);
    }
}
