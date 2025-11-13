package com.course.cleanarchitecture.domain.deiver.model.useCase;

import com.course.cleanarchitecture.domain.deiver.model.DriverEntity;

import java.util.List;

public interface DriverFindAllBySearchParams {
    List<DriverEntity> findAllBySearchParams(String name, Integer age, String city);
    List<DriverEntity> findAllBySearchParams(String name, String city);
}
