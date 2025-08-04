package com.course.cleanarchitecture.entity.pet.plugins.database.repository;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;
import com.course.cleanarchitecture.entity.pet.useCase.mapper.PetMapper;
import com.course.cleanarchitecture.entity.pet.useCase.provider.FindAllPetBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllPetBySearchParamsImpl implements FindAllPetBySearchParamsProvider {

    private final PetMapper petMapper;

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto) {
        PetSearchParamsSpecification petSearchParamsInfra = petMapper.toPetSearchParamsInfra(petSearchParamsDto);

        return petRepositoryJpa.findAll(petSearchParamsInfra);
    }
}
