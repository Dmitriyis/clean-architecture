package com.course.cleanarchitecture.domain.ownerPet.core.application;

import com.course.cleanarchitecture.domain.ownerPet.core.application.queries.GetOwnerPetByIdResult;
import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import org.springframework.stereotype.Service;

@Service
public class OwnerPetMapper {
    public GetOwnerPetByIdResult toGetOwnerPetByIdResult(OwnerPet ownerPet) {
        GetOwnerPetByIdResult getOwnerPetByIdResult = new GetOwnerPetByIdResult(ownerPet.getName(),
                ownerPet.getPhone(),
                ownerPet.getRegistrationDate(),
                ownerPet.getAddress(),
                ownerPet.getPetsId()
        );

        return getOwnerPetByIdResult;
    }
}
