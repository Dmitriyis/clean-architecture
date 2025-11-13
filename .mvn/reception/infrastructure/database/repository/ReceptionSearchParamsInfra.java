package com.course.cleanarchitecture.domain.reception.infrastructure.database.repository;

import com.course.cleanarchitecture.domain.reception.model.ReceptionEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

@Builder
public class ReceptionSearchParamsInfra implements Specification<ReceptionEntity> {

    private String name;

    private Integer age;

    private String city;

    @Override
    public Predicate toPredicate(Root<ReceptionEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
