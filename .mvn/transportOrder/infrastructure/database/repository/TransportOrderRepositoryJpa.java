package com.course.cleanarchitecture.domain.transportOrder.infrastructure.database.repository;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface TransportOrderRepositoryJpa extends JpaRepository<OwnerPetEntity, UUID>, JpaSpecificationExecutor<OwnerPetEntity> {
}
