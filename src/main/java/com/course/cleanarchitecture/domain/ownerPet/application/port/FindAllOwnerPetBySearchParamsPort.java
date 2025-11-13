package com.course.cleanarchitecture.domain.ownerPet.application.port;

import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.ownerPet.application.useCase.dto.OwnerPetSearchParamsDto;

import java.util.List;

public interface FindAllOwnerPetBySearchParamsPort {

    List<OwnerPetEntity> execute(OwnerPetSearchParamsDto ownerPetSearchParamsDto);
}
