package com.course.cleanarchitecture.entity.pet.useCase.provider;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;

import java.util.List;

public interface FindAllPetBySearchParamsProvider {

    List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto);
}
