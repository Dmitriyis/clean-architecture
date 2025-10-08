package com.course.cleanarchitecture.entity.ownerPet.application.port;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.application.useCase.dto.OwnerPetSearchParamsDto;

import java.util.List;

public interface FindAllOwnerPetBySearchParamsPort {

    List<OwnerPetEntity> execute(OwnerPetSearchParamsDto ownerPetSearchParamsDto);
}
