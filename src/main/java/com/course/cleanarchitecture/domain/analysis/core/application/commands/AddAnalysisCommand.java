package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AddAnalysisCommand {
    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCard;

    private AddAnalysisCommand() {

    }

    public AddAnalysisCommand(String name, String description, Integer executionTime, UUID medicalCard) {
        ValidationValueUtils.againstNull(name, "name");
        ValidationValueUtils.againstNull(description, "description");
        ValidationValueUtils.againstNull(executionTime, "executionTime");
        ValidationValueUtils.againstNull(medicalCard, "medicalCard");

        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCard = medicalCard;
    }
}
