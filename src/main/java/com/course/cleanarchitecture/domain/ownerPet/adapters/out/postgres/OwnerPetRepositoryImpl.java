package com.course.cleanarchitecture.domain.ownerPet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import com.course.cleanarchitecture.domain.pet.adapters.out.postgres.PetEntity;
import com.course.cleanarchitecture.domain.pet.adapters.out.postgres.PetRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OwnerPetRepositoryImpl implements OwnerPetRepository {

    private final OwnerPetJpaMapper ownerPetJpaMapper;
    private final PetRepositoryJpa petRepositoryJpa;
    private final OwnerPetRepositoryJpa ownerPetRepositoryJpa;


    @Override
    public UUID save(OwnerPet ownerPet) {
        OwnerPetEntity ownerPetEntity = ownerPetJpaMapper.toOwnerPetEntity(ownerPet);
        return ownerPetRepositoryJpa.save(ownerPetEntity).getId();
    }

    @Override
    public Optional<OwnerPet> findById(UUID id) {
        List<UUID> petIds = petRepositoryJpa.findAllIdsByOwnerId(id);

        return ownerPetRepositoryJpa.findById(id)
                .map(ownerPetEntity -> ownerPetJpaMapper.toOwnerPet(ownerPetEntity, petIds));
    }

    @Override
    public boolean isExists(UUID id) {
        return ownerPetRepositoryJpa.existsById(id);
    }


    @Override
    public Optional<String> findOwnerPetPhoneByPetId(UUID id) {
        return ownerPetRepositoryJpa.findOwnerPetPhoneByPetId(id);
    }
}
