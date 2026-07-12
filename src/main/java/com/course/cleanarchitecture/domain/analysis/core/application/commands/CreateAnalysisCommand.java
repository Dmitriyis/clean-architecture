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

    private UUID medicalCard;

    private LocalDateTime timeAppointment;

    private CreateAnalysisCommand() {

    }

    public CreateAnalysisCommand(String name, String description, Integer executionTime, UUID medicalCard, LocalDateTime timeAppointment) {
        ValidationValueUtils.againstNullOrEmpty(name, "name");
        ValidationValueUtils.againstNullOrEmpty(description, "description");
        ValidationValueUtils.againstNull(medicalCard, "medicalCard");
        ValidationValueUtils.againstNull(timeAppointment, "timeAppointment");
        ValidationValueUtils.againstNull(executionTime, "executionTime");
        ValidationValueUtils.againstNegative(executionTime, "executionTime");

        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCard = medicalCard;
        this.timeAppointment = timeAppointment;
    }
}
