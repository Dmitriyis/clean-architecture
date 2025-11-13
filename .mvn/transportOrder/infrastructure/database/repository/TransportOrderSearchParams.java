package com.course.cleanarchitecture.domain.transportOrder.infrastructure.database.repository;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

@Builder
public class TransportOrderSearchParams implements Specification<OwnerPetEntity> {

    private String name;

    private Integer age;

    private String city;

    @Override
    public Predicate toPredicate(Root<OwnerPetEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
