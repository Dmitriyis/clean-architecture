package com.course.cleanarchitecture.domain.ownerPet.core.application.queries;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetOwnerPetByIdQuery {
    private UUID id;

    private GetOwnerPetByIdQuery() {
    }

    public GetOwnerPetByIdQuery(UUID id) {
        ValidationValueUtils.againstNull(id, "id");
        this.id = id;
    }
}
