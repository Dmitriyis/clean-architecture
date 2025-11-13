package com.course.cleanarchitecture.domain.pet.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepositoryJpa extends JpaRepository<PetEntity, UUID>, JpaSpecificationExecutor<PetEntity> {
}
