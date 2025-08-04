package com.course.cleanarchitecture.entity.deiver.model;

import java.util.List;
import java.util.UUID;

public interface DriverRepository {
    UUID save(DriverEntity pet);

    List<DriverEntity> findAllBySearchParams(String name, Integer age, String city);
    List<DriverEntity> findAllBySearchParams(String name, String city);
}
