package com.course.cleanarchitecture.domain.pet.application.useCase;

import com.course.cleanarchitecture.domain.pet.application.port.DeletePetByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeletePetByIdUseCase {

    private final DeletePetByIdPort deletePetByIdPort;

    public UUID execute(UUID id) {
        return deletePetByIdPort.execute(id);
    }
}
