package com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.mapper;

import com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.dto.GetOwnerPetByIdResponse;
import com.course.cleanarchitecture.domain.ownerPet.core.application.queries.GetOwnerPetByIdResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerPetMapperApi {

    public GetOwnerPetByIdResponse toGetOwnerPetByIdResponse(@NotNull Optional<GetOwnerPetByIdResult> resultOptional) {

        if (resultOptional.isEmpty()) {
            return null;
        }

        GetOwnerPetByIdResult result = resultOptional.get();

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
