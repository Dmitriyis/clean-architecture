package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CreateAnalysisCommand {
    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCardId;

    private LocalDateTime createTime;

    private CreateAnalysisCommand() {

    }

    public CreateAnalysisCommand(String name, String description, Integer executionTime, UUID medicalCardId, LocalDateTime createTime) {
        ValidationValueUtils.againstNullOrEmpty(name, "name");
        ValidationValueUtils.againstNullOrEmpty(description, "description");
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");
        ValidationValueUtils.againstNull(createTime, "createDataTime");
        ValidationValueUtils.againstNull(executionTime, "executionTime");
        ValidationValueUtils.againstNegative(executionTime, "executionTime");

        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCardId = medicalCardId;
        this.createTime = createTime;
    }
}
