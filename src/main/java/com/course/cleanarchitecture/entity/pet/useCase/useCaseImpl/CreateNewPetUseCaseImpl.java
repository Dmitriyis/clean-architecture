package com.course.cleanarchitecture.entity.pet.useCase.useCaseImpl;

import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.GetOwnerPetByIdProvider;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.CreateNewPetUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;
import com.course.cleanarchitecture.entity.pet.useCase.mapper.PetMapper;
import com.course.cleanarchitecture.entity.pet.useCase.provider.SavePetProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewPetUseCaseImpl implements CreateNewPetUseCase {

    private final PetMapper petMapper;
    private final SavePetProvider savePet;
    private final GetOwnerPetByIdProvider getOwnerPetByIdProvider;

    public UUID execute(PetRequestDto petRequestDto) {
        checkExistOwnerPet(petRequestDto);
        UUID petId = UUID.randomUUID();
        PetEntity petEntity = petMapper.toPetEntity(petRequestDto, petId);

        return savePet.execute(petEntity);
    }

    private void checkExistOwnerPet(PetRequestDto petRequestDto) {
        getOwnerPetByIdProvider.execute(petRequestDto.getOwnerId())
                .orElseThrow(() -> {
                    String message = OwnerPetNotFoundException.prepareMessage("OwnerPetEntity", "id", petRequestDto.getOwnerId().toString());
                    return new OwnerPetNotFoundException(message);
                });
    }
}
