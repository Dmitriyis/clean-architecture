package com.course.cleanarchitecture.domain.ownerPet.adapters.out.integration;

import com.course.cleanarchitecture.domain.ownerPet.core.ports.PetProviderForOwnerPet;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetProviderForOwnerPetImpl implements PetProviderForOwnerPet {

    private final PetRepository petRepository;

    @Override
    public Optional<UUID> findOwnerPetIdByPetId(UUID petId) {
        return petRepository.findOwnerPetIdByPetId(petId);
    }
}
