package com.course.cleanarchitecture.domain.ownerPet.core.application.queries;

import java.util.Optional;

public interface GetOwnerPetByIdQueryHandler {
    GetOwnerPetByIdResult execute(GetOwnerPetByIdQuery query);
}
