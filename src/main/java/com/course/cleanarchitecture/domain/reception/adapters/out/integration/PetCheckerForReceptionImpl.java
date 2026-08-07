package com.course.cleanarchitecture.domain.reception.adapters.out.integration;

import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.reception.core.ports.PetCheckerForReception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetCheckerForReceptionImpl implements PetCheckerForReception {

    private final PetRepository petRepository;

    @Override
    public boolean isPetExists(UUID petId) {
        return petRepository.isPetExists(petId);
    }
}
