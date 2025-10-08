package com.course.cleanarchitecture.entity.ownerPet.useCase;

import com.course.cleanarchitecture.entity.ownerPet.port.DeleteOwnerPetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteOwnerPetByIdUseCase {

    private final DeleteOwnerPetByIdPort deleteOwnerPetByIdPort;


    public UUID execute(UUID id) {
        return deleteOwnerPetByIdPort.execute(id);
    }
}
