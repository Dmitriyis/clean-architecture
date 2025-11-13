package com.course.cleanarchitecture.domain.transportOrder.model.useCase;

import com.course.cleanarchitecture.domain.transportOrder.model.TransportOrderEntity;

import java.util.List;

public interface TransportOrderFindAllBySearchParams {
    List<TransportOrderEntity> findAllBySearchParams(String name, Integer age, String city);
    List<TransportOrderEntity> findAllBySearchParams(String name, String city);
}
