package com.course.cleanarchitecture.entity.pet.useCase;

import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.port.GetOwnerPetByIdPort;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.port.SavePetPort;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;
import com.course.cleanarchitecture.entity.pet.useCase.mapper.PetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewPetUseCase {

    private final PetMapper petMapper;
    private final SavePetPort savePetPort;
    private final GetOwnerPetByIdPort getOwnerPetByIdPort;

    public UUID execute(PetRequestDto petRequestDto) {
        checkExistOwnerPet(petRequestDto);
        UUID petId = UUID.randomUUID();
        PetEntity petEntity = petMapper.toPetEntity(petRequestDto, petId);

        return savePetPort.execute(petEntity);
    }

    private void checkExistOwnerPet(PetRequestDto petRequestDto) {
        getOwnerPetByIdPort.execute(petRequestDto.getOwnerId())
                .orElseThrow(() -> {
                    String message = OwnerPetNotFoundException.prepareMessage("OwnerPetEntity", "id", petRequestDto.getOwnerId().toString());
                    return new OwnerPetNotFoundException(message);
                });
    }
}
