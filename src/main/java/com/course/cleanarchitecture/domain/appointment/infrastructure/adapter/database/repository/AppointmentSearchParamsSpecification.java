package com.course.cleanarchitecture.domain.appointment.infrastructure.adapter.database.repository;

import com.course.cleanarchitecture.domain.appointment.model.AppointmentEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

@Builder
public class AppointmentSearchParamsSpecification implements Specification<AppointmentEntity> {

    private String name;

    private Integer age;

    private String city;

    @Override
    public Predicate toPredicate(Root<AppointmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
