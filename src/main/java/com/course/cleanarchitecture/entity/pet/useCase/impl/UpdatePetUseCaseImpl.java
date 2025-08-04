package com.course.cleanarchitecture.entity.pet.useCase.impl;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.GetOwnerPetByIdUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.GetOwnerPetByIdProvider;
import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.UpdatePetUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetUpdateDto;
import com.course.cleanarchitecture.entity.pet.useCase.mapper.PetMapper;
import com.course.cleanarchitecture.entity.pet.useCase.provider.GetPetByIdProvider;
import com.course.cleanarchitecture.entity.pet.useCase.provider.UpdatePetProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdatePetUseCaseImpl implements UpdatePetUseCase {

    private final PetMapper petMapper;
    private final UpdatePetProvider updatePetProvider;
    private final GetPetByIdProvider getPetByIdProvider;
    private final GetOwnerPetByIdProvider getOwnerPetByIdProvider;

    @Override
    public UUID execute(PetUpdateDto petUpdateDto) {
        PetEntity petEntityFromDataBase = getPetEntityIfExistInDataBase(petUpdateDto);
        checkExistOwnerPetEntity(petUpdateDto);

        PetEntity petEntity = petMapper.toPetEntity(petUpdateDto, petEntityFromDataBase);
        return updatePetProvider.execute(petEntity);
    }

    private PetEntity getPetEntityIfExistInDataBase(PetUpdateDto petUpdateDto) {
        return getPetByIdProvider.execute(petUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("PetEntity", "id", petUpdateDto.getId()
                            .toString());
                    return new PetNotFoundException(message);
                });
    }

    private void checkExistOwnerPetEntity(PetUpdateDto petUpdateDto) {
        getOwnerPetByIdProvider.execute(petUpdateDto.getOwnerId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("OwnerPetEntity", "id", petUpdateDto.getOwnerId().toString());
                    return new OwnerPetNotFoundException(message);
                });
    }
}
