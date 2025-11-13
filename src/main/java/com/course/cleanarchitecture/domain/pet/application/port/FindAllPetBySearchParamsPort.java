package com.course.cleanarchitecture.domain.pet.application.port;

import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import com.course.cleanarchitecture.domain.pet.application.useCase.dto.PetSearchParamsDto;

import java.util.List;

public interface FindAllPetBySearchParamsPort {

    List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto);
}
