package com.course.cleanarchitecture.domain.ownerPet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import com.course.cleanarchitecture.domain.ownerPet.exceptions.OwnerPetNotFoundException;
import com.course.cleanarchitecture.domain.pet.adapters.out.postgres.PetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OwnerPetRepositoryImpl implements OwnerPetRepository {

    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;

    @Override
    public UUID save(OwnerPet ownerPet) {
        OwnerPetEntity ownerPetEntity = OwnerPetToOwnerPetEntityMapper.OwnerPetToOwnerPetEntity(ownerPet);
        return ownerPetRepositoryJpa.save(ownerPetEntity).getId();
    }

    @Override
    public OwnerPet findById(UUID id) {
        OwnerPetEntity ownerPetEntity = ownerPetRepositoryJpa.findById(id)
                .orElseThrow(() -> new OwnerPetNotFoundException("Not found OwnerPet by id: " + id + "."));

        List<UUID> petsId = ownerPetEntity.getPets()
                .stream()
                .map(PetEntity::getId)
                .collect(Collectors.toList());

        return new OwnerPet(ownerPetEntity.getId(), ownerPetEntity.getName(), ownerPetEntity.getRegistrationDate(), ownerPetEntity.getAddress(), petsId);
    }
}
