package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateAnalysisCommand {
    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCardId;

    private CreateAnalysisCommand() {

    }

    public CreateAnalysisCommand(String name, String description, Integer executionTime, UUID medicalCardId) {
        ValidationValueUtils.againstNullOrEmpty(name, "name");
        ValidationValueUtils.againstNullOrEmpty(description, "description");
        ValidationValueUtils.againstNull(executionTime, "executionTime");
        ValidationValueUtils.againstNegative(executionTime, "executionTime");
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");

        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCardId = medicalCardId;
    }
}
