package com.course.cleanarchitecture.entity.ownerPet.port;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;

import java.util.List;

public interface FindAllOwnerPetBySearchParamsPort {

    List<OwnerPetEntity> execute(OwnerPetSearchParamsDto ownerPetSearchParamsDto);
}
