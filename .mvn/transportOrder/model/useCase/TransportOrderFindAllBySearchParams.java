package com.course.cleanarchitecture.entity.transportOrder.model.useCase;

import com.course.cleanarchitecture.entity.transportOrder.model.TransportOrderEntity;

import java.util.List;

public interface TransportOrderFindAllBySearchParams {
    List<TransportOrderEntity> findAllBySearchParams(String name, Integer age, String city);
    List<TransportOrderEntity> findAllBySearchParams(String name, String city);
}
