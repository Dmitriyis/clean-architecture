package com.course.cleanarchitecture.entity.ownerPet.application.useCase;

import com.course.cleanarchitecture.entity.ownerPet.application.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.application.port.FindAllOwnerPetBySearchParamsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllOwnerPetBySearchParamsUseCase {

    private final FindAllOwnerPetBySearchParamsPort findAllOwnerPetBySearchParamsPort;


    public List<OwnerPetEntity> execute(OwnerPetSearchParamsDto ownerPetSearchParamsDto) {
        return findAllOwnerPetBySearchParamsPort.execute(ownerPetSearchParamsDto);
    }
}
