package com.course.cleanarchitecture.domain.analysis.adapters.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnalysisRepositoryJpa extends JpaRepository<AnalysisEntity, UUID>, JpaSpecificationExecutor<AnalysisEntity> {

    @Query("select mc from AnalysisEntity mc where mc.medicalCard.id = :medicalCardId")
    List<AnalysisEntity> findAllByMedicalCardId(@Param("medicalCardId") UUID medicalCardId);
}
