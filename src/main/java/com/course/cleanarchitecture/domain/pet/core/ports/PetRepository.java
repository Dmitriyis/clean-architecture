package com.course.cleanarchitecture.domain.pet.core.ports;

import com.course.cleanarchitecture.domain.pet.core.model.Pet;

import java.util.UUID;

public interface PetRepository {
    UUID save(Pet pet);

    Pet findByMedicalCardId(UUID id);

    void update(Pet pet);
}
