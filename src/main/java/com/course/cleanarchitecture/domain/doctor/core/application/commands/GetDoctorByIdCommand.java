package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetDoctorByIdCommand {
    private UUID id;

    private GetDoctorByIdCommand() {
    }

    public GetDoctorByIdCommand(UUID id) {
        ValidationValueUtils.againstNull(id, "id");
        this.id = id;
    }
}
