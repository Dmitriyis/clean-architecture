package com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.mapper;

import com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.dto.GetOwnerPetByIdResponse;
import com.course.cleanarchitecture.domain.ownerPet.core.application.queries.GetOwnerPetByIdResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class OwnerPetMapperApi {

    public GetOwnerPetByIdResponse toGetOwnerPetByIdResponse(GetOwnerPetByIdResult result) {
        GetOwnerPetByIdResponse getOwnerPetByIdResponse = new GetOwnerPetByIdResponse(
                result.name(),
                result.phone(),
                result.registrationDate(),
                result.address(),
                result.petsId()
        );

        return getOwnerPetByIdResponse;
    }

}
