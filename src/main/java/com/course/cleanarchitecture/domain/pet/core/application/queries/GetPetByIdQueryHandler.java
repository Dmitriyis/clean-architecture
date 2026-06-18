package com.course.cleanarchitecture.domain.pet.core.application.queries;

public interface GetPetByIdQueryHandler {
    GetPetByIdQueryResponse execute(GetPetByIdQuery getPetByIdQueryCommand) throws NoSuchFieldException;
}
