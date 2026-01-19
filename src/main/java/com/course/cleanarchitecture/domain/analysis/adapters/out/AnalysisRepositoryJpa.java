package com.course.cleanarchitecture.domain.analysis.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnalysisRepositoryJpa extends JpaRepository<AnalysisEntity, UUID>, JpaSpecificationExecutor<AnalysisEntity> {
}
