package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepositoryJpa extends JpaRepository<PetEntity, UUID>, JpaSpecificationExecutor<PetEntity> {

    @Query("select p from PetEntity as p where p.medicalCard.id = :medicalCardId")
    PetEntity findByMedicalCardId(@Param("medicalCardId") UUID medicalCardId);
}
