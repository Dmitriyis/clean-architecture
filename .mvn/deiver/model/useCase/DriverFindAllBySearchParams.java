package com.course.cleanarchitecture.entity.deiver.model.useCase;

import com.course.cleanarchitecture.entity.deiver.model.DriverEntity;

import java.util.List;

public interface DriverFindAllBySearchParams {
    List<DriverEntity> findAllBySearchParams(String name, Integer age, String city);
    List<DriverEntity> findAllBySearchParams(String name, String city);
}
