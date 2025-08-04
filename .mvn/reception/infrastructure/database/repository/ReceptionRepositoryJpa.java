package com.course.cleanarchitecture.entity.reception.infrastructure.database.repository;

import com.course.cleanarchitecture.entity.reception.model.ReceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReceptionRepositoryJpa extends JpaRepository<ReceptionEntity, UUID>, JpaSpecificationExecutor<ReceptionEntity> {
}
