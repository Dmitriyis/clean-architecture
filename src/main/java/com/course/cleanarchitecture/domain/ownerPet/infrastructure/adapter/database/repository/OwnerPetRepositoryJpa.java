package com.course.cleanarchitecture.domain.ownerPet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.ownerPet.model.OwnerPetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerPetRepositoryJpa extends JpaRepository<OwnerPetEntity, UUID>, JpaSpecificationExecutor<OwnerPetEntity> {
}
