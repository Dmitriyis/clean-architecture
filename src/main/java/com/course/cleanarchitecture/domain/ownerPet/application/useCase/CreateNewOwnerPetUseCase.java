package com.course.cleanarchitecture.domain.ownerPet.application.useCase;

import com.course.cleanarchitecture.domain.ownerPet.application.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.domain.ownerPet.application.useCase.mapper.OwnerPetMapper;
import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.ownerPet.application.port.SaveOwnerPetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNewOwnerPetUseCase {

    private final OwnerPetMapper ownerPetMapper;
    private final SaveOwnerPetPort saveOwnerPetPort;

    public UUID execute(OwnerPetRequestDto ownerPetRequestDto) {
        UUID uuid = UUID.randomUUID();
        OwnerPetEntity petEntity = ownerPetMapper.toPetEntity(ownerPetRequestDto, uuid);
        return saveOwnerPetPort.execute(petEntity);
    }
}
