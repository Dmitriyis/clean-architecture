package com.course.cleanarchitecture.entity.analysis.plugins.database.repository;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public class AnalysisSearchParamsSpecification implements Specification<AnalysisEntity> {

    private UUID id;

    private String name;

    private Integer leadTime;

    private BigDecimal price;

    private String recommendations;

    @Override
    public Predicate toPredicate(Root<AnalysisEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
