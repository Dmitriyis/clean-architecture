package com.course.cleanarchitecture.entity.doctor.adapter.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepositoryJpa extends JpaRepository<DoctorEntity, UUID>, JpaSpecificationExecutor<DoctorEntity> {
}
