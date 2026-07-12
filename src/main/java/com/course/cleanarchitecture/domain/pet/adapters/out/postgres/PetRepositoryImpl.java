package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.pet.core.model.Pet;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository {

    private final PetJpaMapper petJpaMapper;
    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID save(Pet pet) {
        PetEntity petEntity = petJpaMapper.petToPetEntity(pet);
        return petRepositoryJpa.save(petEntity).getId();
    }

    @Override
    public Optional<Pet> findByMedicalCardId(UUID id) {
        Optional<PetEntity> petEntityOptional = petRepositoryJpa.findByMedicalCardId(id);

        if (petEntityOptional.isEmpty()) {
            return Optional.empty();
        }

        PetEntity petEntity = petEntityOptional.get();

        Pet pet = petJpaMapper.petTo(petEntity);

        return Optional.ofNullable(pet);
    }

    @Override
    public Optional<UUID> findOwnerPetIdByMedicalCardId(UUID id) {
        return petRepositoryJpa.findOwnerPetIdByMedicalCardId(id);
    }

    @Override
    public boolean existsPetByMedicalCardId(UUID medicalCardId) {
        return petRepositoryJpa.existsByMedicalCardId(medicalCardId);
    }

    @Override
    public void update(Pet pet) {
        PetEntity petEntity = petJpaMapper.petToPetEntity(pet);
        petRepositoryJpa.save(petEntity);
    }
}