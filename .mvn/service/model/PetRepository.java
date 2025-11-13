package com.course.cleanarchitecture.domain.service.model;

import java.util.List;
import java.util.UUID;

public interface PetRepository {
    UUID save(ServiceEntity pet);

    List<ServiceEntity> findAllBySearchParams(String name, Integer age, String city);
    List<ServiceEntity> findAllBySearchParams(String name, String city);
}
