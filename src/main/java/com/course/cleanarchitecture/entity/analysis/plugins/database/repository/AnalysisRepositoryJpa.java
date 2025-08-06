package com.course.cleanarchitecture.entity.analysis.plugins.database.repository;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AnalysisRepositoryJpa extends JpaRepository<AnalysisEntity, UUID>, JpaSpecificationExecutor<AnalysisEntity> {
}
