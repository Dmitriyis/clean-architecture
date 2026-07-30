package com.course.cleanarchitecture.domain.pet.adapters.out.integration;

import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import com.course.cleanarchitecture.domain.pet.core.ports.OwnerPetCheckerForPet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OwnerPetCheckerImpl implements OwnerPetCheckerForPet {

    private final OwnerPetRepository ownerPetRepository;

    @Override
    public boolean isOwnerPetExists(UUID ownerPetId) {
        return ownerPetRepository.isExists(ownerPetId);
    }
}
