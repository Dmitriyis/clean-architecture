package com.course.cleanarchitecture.entity.pet.useCase.mapper;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.model.GeneratePetEntity;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.plugins.database.repository.PetSearchParamsSpecification;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetUpdateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PetMapperImpl implements PetMapper {

    @Override
    public PetEntity toPetEntity(PetRequestDto pet, UUID petId) {
        return GeneratePetEntity.generate(petId, pet.getName(), pet.getWeight(), pet.getAge(), pet.getRegistrationDate(), pet.getOwnerId());
    }

    @Override
    public PetEntity toPetEntity(PetUpdateDto petUpdateDto, PetEntity petEntity) {
        petEntity.updateName(petUpdateDto.getName());
        petEntity.updateAge(petUpdateDto.getAge());
        petEntity.updateWeight(petUpdateDto.getWeight());

        OwnerPetEntity ownerPetEntity = new OwnerPetEntity(petUpdateDto.getOwnerId(), null, null, null, null);
        petEntity.updateOwnerPet(ownerPetEntity);

        return petEntity;
    }

    @Override
    public PetSearchParamsSpecification toPetSearchParamsInfra(PetSearchParamsDto pet) {
        return null;
    }
}
