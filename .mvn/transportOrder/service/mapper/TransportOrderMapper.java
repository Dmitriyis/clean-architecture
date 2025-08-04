package com.course.cleanarchitecture.entity.transportOrder.service.mapper;

import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.transportOrder.service.dto.TransportOrderDto;

public class TransportOrderMapper {
    public OwnerPetEntity toPetEntity(TransportOrderDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
