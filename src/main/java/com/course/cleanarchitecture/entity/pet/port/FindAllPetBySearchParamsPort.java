package com.course.cleanarchitecture.entity.pet.port;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;

import java.util.List;

public interface FindAllPetBySearchParamsPort {

    List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto);
}
