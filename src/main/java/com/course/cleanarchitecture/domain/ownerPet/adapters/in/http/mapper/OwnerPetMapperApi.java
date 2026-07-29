package com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.mapper;

import com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.dto.GetOwnerPetByIdResponse;
import com.course.cleanarchitecture.domain.ownerPet.core.application.queries.GetOwnerPetByIdResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerPetMapperApi {
    GetOwnerPetByIdResponse toGetOwnerPetByIdResponse(GetOwnerPetByIdResult getOwnerPetByIdResult);
}
