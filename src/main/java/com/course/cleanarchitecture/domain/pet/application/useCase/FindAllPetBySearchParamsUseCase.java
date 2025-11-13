package com.course.cleanarchitecture.domain.pet.application.useCase;

import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import com.course.cleanarchitecture.domain.pet.application.port.FindAllPetBySearchParamsPort;
import com.course.cleanarchitecture.domain.pet.application.useCase.dto.PetSearchParamsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindAllPetBySearchParamsUseCase {

    private final FindAllPetBySearchParamsPort findAllPetBySearchParamsPort;

    public List<PetEntity> execute(PetSearchParamsDto petSearchParamsDto) {
        return findAllPetBySearchParamsPort.execute(petSearchParamsDto);
    }
}
