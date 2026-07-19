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

    private String conclusions;

    private LocalDateTime startReception;

    private LocalDateTime endReception;

    private CreateReceptionCommand() {

    }

    public CreateReceptionCommand(UUID petId, UUID doctorId, List<String> analyses, String conclusions, LocalDateTime startReception, LocalDateTime endReception) {
        ValidationValueUtils.againstNull(petId, "petId");
        ValidationValueUtils.againstNull(doctorId, "doctorId");
        ValidationValueUtils.againstNullOrEmpty(conclusions, "conclusions");
        ValidationValueUtils.againstNull(startReception, "startReception");
        ValidationValueUtils.againstDateTimeEqualCurrent(startReception, "startReception");
        ValidationValueUtils.againstNull(endReception, "endReception");
        ValidationValueUtils.againstDateTimeEqualCurrent(endReception, "endReception");

        this.petId = petId;
        this.doctorId = doctorId;
        this.analyses = analyses;
        this.conclusions = conclusions;
        this.startReception = startReception;
        this.endReception = endReception;
    }
}
