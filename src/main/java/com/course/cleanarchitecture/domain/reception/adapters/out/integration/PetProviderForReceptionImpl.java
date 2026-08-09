package com.course.cleanarchitecture.domain.reception.adapters.out.integration;

import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.reception.core.ports.PetProviderForReception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PetProviderForReceptionImpl implements PetProviderForReception {

    private final PetRepository petRepository;

    @Override
    public boolean isPetExists(UUID petId) {
        return petRepository.isPetExists(petId);
    }
}
