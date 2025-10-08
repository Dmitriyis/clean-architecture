package com.course.cleanarchitecture.entity.ownerPet.useCase;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.port.FindAllOwnerPetBySearchParamsPort;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetSearchParamsDto;
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
