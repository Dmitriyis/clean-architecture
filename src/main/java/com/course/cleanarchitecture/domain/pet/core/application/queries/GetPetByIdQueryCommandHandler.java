package com.course.cleanarchitecture.domain.pet.core.application.queries;

import java.util.List;

public interface GetPetByIdQueryCommandHandler {
    GetPetByIdQueryResponse execute(GetPetByIdQueryCommand getPetByIdQueryCommand) throws NoSuchFieldException;
}
