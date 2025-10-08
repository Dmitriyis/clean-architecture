package com.course.cleanarchitecture.entity.pet.useCase;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.port.GetOwnerPetByIdPort;
import com.course.cleanarchitecture.entity.pet.exceptions.PetNotFoundException;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.port.GetPetByIdPort;
import com.course.cleanarchitecture.entity.pet.port.UpdatePetPort;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetUpdateDto;
import com.course.cleanarchitecture.entity.pet.useCase.mapper.PetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdatePetUseCase {

    private final PetMapper petMapper;
    private final UpdatePetPort updatePetPort;
    private final GetPetByIdPort getPetByIdPort;
    private final GetOwnerPetByIdPort getOwnerPetByIdPort;


    public UUID execute(PetUpdateDto petUpdateDto) {
        PetEntity petEntityFromDataBase = getPetEntityIfExistInDataBase(petUpdateDto);
        checkExistOwnerPetEntity(petUpdateDto.getOwnerId());

        PetEntity petEntity = petMapper.toPetEntity(petUpdateDto, petEntityFromDataBase);
        return updatePetPort.execute(petEntity);
    }

    private PetEntity getPetEntityIfExistInDataBase(PetUpdateDto petUpdateDto) {
        return getPetByIdPort.execute(petUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("PetEntity", "id", petUpdateDto.getId().toString());
                    return new PetNotFoundException(message);
                });
    }

    private void checkExistOwnerPetEntity(UUID ownerId) {
        getOwnerPetByIdPort.execute(ownerId)
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("OwnerPetEntity", "id", ownerId.toString());
                    return new OwnerPetNotFoundException(message);
                });
    }
}
