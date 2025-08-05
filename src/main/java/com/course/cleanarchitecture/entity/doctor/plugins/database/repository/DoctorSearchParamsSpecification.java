package com.course.cleanarchitecture.entity.doctor.plugins.database.repository;

import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

@Builder
public class DoctorSearchParamsSpecification implements Specification<DoctorEntity> {

    private UUID id;

    private String name;

    private TypeProfession profession;

    private Integer workExperience;

    @Override
    public Predicate toPredicate(Root<DoctorEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
