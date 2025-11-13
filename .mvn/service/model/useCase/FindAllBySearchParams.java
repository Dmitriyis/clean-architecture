package com.course.cleanarchitecture.domain.service.model.useCase;

import com.course.cleanarchitecture.domain.service.model.ServiceEntity;

import java.util.List;

public interface FindAllBySearchParams {
    List<ServiceEntity> findAllBySearchParams(String name, Integer age, String city);
    List<ServiceEntity> findAllBySearchParams(String name, String city);
}
