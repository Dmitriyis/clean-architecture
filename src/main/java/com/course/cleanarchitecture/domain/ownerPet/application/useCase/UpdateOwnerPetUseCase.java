package com.course.cleanarchitecture.domain.ownerPet.application.useCase;

import com.course.cleanarchitecture.domain.ownerPet.application.useCase.dto.OwnerPetUpdateDto;
import com.course.cleanarchitecture.domain.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.ownerPet.application.port.GetOwnerPetByIdPort;
import com.course.cleanarchitecture.domain.ownerPet.application.port.UpdateOwnerPetPort;
import com.course.cleanarchitecture.domain.ownerPet.application.useCase.mapper.OwnerPetMapper;
import com.course.cleanarchitecture.domain.pet.exceptions.PetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateOwnerPetUseCase {

    private final OwnerPetMapper ownerPetMapper;
    private final UpdateOwnerPetPort updateOwnerPetPort;
    private final GetOwnerPetByIdPort getOwnerPetByIdPort;

    public UUID execute(OwnerPetUpdateDto ownerPetUpdateDto) {
        OwnerPetEntity ownerPetEntityFromDataBase = getOwnerPetByIdPort.execute(ownerPetUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = PetNotFoundException.prepareMessage("OwnerPetEntity", "id", ownerPetUpdateDto.getId().toString());
                    return new OwnerPetNotFoundException(message);
                });

        OwnerPetEntity ownerPetEntity = ownerPetMapper.toPetEntity(ownerPetUpdateDto, ownerPetEntityFromDataBase);

        return updateOwnerPetPort.execute(ownerPetEntity);
    }
}
