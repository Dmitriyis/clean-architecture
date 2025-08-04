package com.course.cleanarchitecture.entity.pet.useCase;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;

import java.util.List;

public interface FindAllPetBySearchParamsUseCase {
    List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto);
}
