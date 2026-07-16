package com.course.cleanarchitecture.domain.pet.core.ports;

import com.course.cleanarchitecture.domain.pet.core.model.Pet;

import java.util.Optional;
import java.util.UUID;

public interface PetRepository {
    UUID save(Pet pet);

    Optional<Pet> findByMedicalCardId(UUID id);

    Optional<UUID> findOwnerPetIdByPetId(UUID id);

    boolean existsPetByMedicalCardId(UUID medicalCardId);

    void update(Pet pet);
}
