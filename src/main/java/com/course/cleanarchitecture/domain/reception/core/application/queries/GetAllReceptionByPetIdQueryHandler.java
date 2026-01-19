package com.course.cleanarchitecture.domain.reception.core.application.queries;

import java.util.List;

public interface GetAllReceptionByPetIdQueryHandler {
    List<GetAllReceptionByPetIdResponse> execute(GetAllReceptionByPetIdQueryCommand getAllReceptionByPetIdQueryCommand);
}
