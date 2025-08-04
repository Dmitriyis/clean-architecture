package com.course.cleanarchitecture.entity.deiver.service.mapper;

import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.deiver.service.dto.DriverDto;

public class DriverMapper {
    public OwnerPetEntity toPetEntity(DriverDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
