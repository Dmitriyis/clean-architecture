package com.course.cleanarchitecture.entity.ownerPet.plugins.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.mapper.OwnerPetMapper;
import com.course.cleanarchitecture.entity.ownerPet.useCase.provider.FindAllOwnerPetBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllOwnerPetBySearchParamsImpl implements FindAllOwnerPetBySearchParamsProvider {

    private final OwnerPetMapper ownerPetMapper;

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public List<OwnerPetEntity> execute(OwnerPetSearchParamsDto ownerPetSearchParamsDto) {
        OwnerPetSearchParamsSpecification petSearchParamsInfra = ownerPetMapper.toOwnerPetSearchParamsInfra(ownerPetSearchParamsDto);
        return ownerPetRepositoryJpa.findAll(petSearchParamsInfra);
    }
}
