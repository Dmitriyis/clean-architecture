package com.course.cleanarchitecture.domain.reception.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class CreateReceptionCommand {

    private UUID petId;

    private UUID doctorId;

    private List<String> analyses;

    private String description;

    private LocalDateTime startReception;

    private LocalDateTime endReception;

    private CreateReceptionCommand() {

    }

    public CreateReceptionCommand(UUID petId, UUID doctorId, List<String> analyses, String description, LocalDateTime startReception, LocalDateTime endReception) {
        ValidationValueUtils.againstNull(petId, "petId");
        ValidationValueUtils.againstNull(doctorId, "doctorId");
        ValidationValueUtils.againstNullOrEmpty(description, "description");
        ValidationValueUtils.againstNull(startReception, "startReception");
        ValidationValueUtils.againstDateTimeEqualCurrent(startReception, "startReception");
        ValidationValueUtils.againstNull(endReception, "endReception");
        ValidationValueUtils.againstDateTimeEqualCurrent(endReception, "endReception");

        this.petId = petId;
        this.doctorId = doctorId;
        this.analyses = analyses;
        this.description = description;
        this.startReception = startReception;
        this.endReception = endReception;
    }
}
