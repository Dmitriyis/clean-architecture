package com.course.cleanarchitecture.domain.reception.core.application.queries;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetAllReceptionByPetIdQuery {
    private UUID petId;

    public GetAllReceptionByPetIdQuery() {
    }

    public GetAllReceptionByPetIdQuery(UUID petId) {
        ValidationValueUtils.againstNull(petId, "petId");
        this.petId = petId;
    }
}
