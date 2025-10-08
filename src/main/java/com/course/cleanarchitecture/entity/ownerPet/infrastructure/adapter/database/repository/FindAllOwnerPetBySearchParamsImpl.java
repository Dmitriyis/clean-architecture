package com.course.cleanarchitecture.entity.ownerPet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.application.port.FindAllOwnerPetBySearchParamsPort;
import com.course.cleanarchitecture.entity.ownerPet.application.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.application.useCase.mapper.OwnerPetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllOwnerPetBySearchParamsImpl implements FindAllOwnerPetBySearchParamsPort {

    private final OwnerPetMapper ownerPetMapper;

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public List<OwnerPetEntity> execute(OwnerPetSearchParamsDto ownerPetSearchParamsDto) {
        OwnerPetSearchParamsSpecification petSearchParamsInfra = ownerPetMapper.toOwnerPetSearchParamsInfra(ownerPetSearchParamsDto);
        return ownerPetRepositoryJpa.findAll(petSearchParamsInfra);
    }
}
