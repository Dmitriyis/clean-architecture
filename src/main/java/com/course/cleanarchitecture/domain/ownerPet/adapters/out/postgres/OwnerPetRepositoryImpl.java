package com.course.cleanarchitecture.domain.ownerPet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OwnerPetRepositoryImpl implements OwnerPetRepository {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public UUID save(OwnerPet ownerPet) {
        return null;
    }

    @Override
    public OwnerPet findById(UUID id) {
        return null;
    }
}
