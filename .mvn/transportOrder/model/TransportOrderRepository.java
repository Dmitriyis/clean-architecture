package com.course.cleanarchitecture.domain.transportOrder.model;

import java.util.List;
import java.util.UUID;

public interface TransportOrderRepository {
    UUID save(TransportOrderEntity pet);

    List<TransportOrderEntity> findAllBySearchParams(String name, Integer age, String city);
    List<TransportOrderEntity> findAllBySearchParams(String name, String city);
}
