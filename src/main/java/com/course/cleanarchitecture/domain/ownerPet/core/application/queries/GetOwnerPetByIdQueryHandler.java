package com.course.cleanarchitecture.domain.ownerPet.core.application.queries;

public interface GetOwnerPetByIdQueryHandler {
    GetOwnerPetByIdResult execute(GetOwnerPetByIdQuery query);
}
