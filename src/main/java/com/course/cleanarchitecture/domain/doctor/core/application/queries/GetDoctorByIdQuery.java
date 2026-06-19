package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetDoctorByIdQuery {
    private UUID id;

    private GetDoctorByIdQuery() {
    }

    public GetDoctorByIdQuery(UUID id) {
        ValidationValueUtils.againstNull(id, "id");
        this.id = id;
    }
}
