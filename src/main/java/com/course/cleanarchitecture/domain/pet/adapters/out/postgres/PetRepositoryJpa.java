package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PetRepositoryJpa extends JpaRepository<PetEntity, UUID>, JpaSpecificationExecutor<PetEntity> {

    @Query("select p from PetEntity as p where p.medicalCard.id = :medicalCardId")
    Optional<PetEntity> findByMedicalCardId(@Param("medicalCardId") UUID medicalCardId);

    @Query("select p.id from PetEntity p where p.ownerId = :ownerId")
    List<UUID> findAllIdsByOwnerId(UUID ownerId);

    boolean existsByMedicalCardId(UUID medicalCardId);

    @Query("select p.ownerId from PetEntity p where p.id = :petId")
    Optional<UUID> findOwnerPetIdByPetIdId(@Param("petId") UUID petId);
}
