package com.course.cleanarchitecture.domain.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.appointment.model.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepositoryJpa extends JpaRepository<AppointmentEntity, UUID>, JpaSpecificationExecutor<AppointmentEntity> {
}
