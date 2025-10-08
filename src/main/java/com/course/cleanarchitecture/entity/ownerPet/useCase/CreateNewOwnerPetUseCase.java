package com.course.cleanarchitecture.entity.ownerPet.useCase;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.port.SaveOwnerPetPort;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.mapper.OwnerPetMapper;
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
