package com.course.cleanarchitecture.domain.transportOrder.service.mapper;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.transportOrder.service.dto.TransportOrderDto;

public class TransportOrderMapper {
    public OwnerPetEntity toPetEntity(TransportOrderDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
