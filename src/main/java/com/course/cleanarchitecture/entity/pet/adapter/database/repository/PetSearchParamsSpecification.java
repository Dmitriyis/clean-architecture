package com.course.cleanarchitecture.entity.pet.adapter.database.repository;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

@Builder
public class PetSearchParamsSpecification implements Specification<PetEntity> {

    private String name;

    private Integer age;

    private String city;

    @Override
    public Predicate toPredicate(Root<PetEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
