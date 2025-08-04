package com.course.cleanarchitecture.entity.ownerPet.plugins.database.repository;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

@Builder
public class OwnerPetSearchParamsSpecification implements Specification<OwnerPetEntity> {

    private String name;

    private Integer age;

    private String city;

    @Override
    public Predicate toPredicate(Root<OwnerPetEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
