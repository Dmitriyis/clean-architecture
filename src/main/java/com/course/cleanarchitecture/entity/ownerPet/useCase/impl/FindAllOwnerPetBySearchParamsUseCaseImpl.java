package com.course.cleanarchitecture.entity.ownerPet.useCase.impl;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.FindAllOwnerPetBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.FindAllOwnerPetBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllOwnerPetBySearchParamsUseCaseImpl implements FindAllOwnerPetBySearchParamsUseCase {

  private final FindAllOwnerPetBySearchParamsProvider ownerPetBySearchParamsProvider;

    @Override
    public List<OwnerPetEntity> execute(OwnerPetSearchParamsDto ownerPetSearchParamsDto) {
        return ownerPetBySearchParamsProvider.execute(ownerPetSearchParamsDto);
    }
}
