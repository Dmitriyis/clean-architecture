package com.course.cleanarchitecture.entity.pet.useCase.impl;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.FindAllPetBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;
import com.course.cleanarchitecture.entity.pet.useCase.provider.FindAllPetBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllPetBySearchParamsUseCaseImpl implements FindAllPetBySearchParamsUseCase {

  private final FindAllPetBySearchParamsProvider petBySearchParamsProvider;

    @Override
    public List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto) {
        return petBySearchParamsProvider.execute(petSearchParamsDto);
    }
}
