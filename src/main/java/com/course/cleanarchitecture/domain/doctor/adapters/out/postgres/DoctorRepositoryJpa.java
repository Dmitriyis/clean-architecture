package com.course.cleanarchitecture.domain.doctor.adapters.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepositoryJpa extends JpaRepository<DoctorEntity, UUID>, JpaSpecificationExecutor<DoctorEntity> {
}
