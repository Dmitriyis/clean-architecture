package com.course.cleanarchitecture.entity.pet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.application.port.FindAllPetBySearchParamsPort;
import com.course.cleanarchitecture.entity.pet.application.useCase.dto.PetSearchParamsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllPetBySearchParamsImpl implements FindAllPetBySearchParamsPort {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto) {
        PetSearchParamsSpecification petSearchParamsInfra = toPetSearchParamsInfra(petSearchParamsDto);

        return petRepositoryJpa.findAll(petSearchParamsInfra);
    }

    private PetSearchParamsSpecification toPetSearchParamsInfra(PetSearchParamsDto petSearchParamsDto) {
        PetSearchParamsSpecification petSearchParamsSpecification = PetSearchParamsSpecification
                .builder()
                .age(petSearchParamsDto.getAge())
                .city(petSearchParamsDto.getCity())
                .name(petSearchParamsDto.getName())
                .build();
        return petSearchParamsSpecification;
    }
}
