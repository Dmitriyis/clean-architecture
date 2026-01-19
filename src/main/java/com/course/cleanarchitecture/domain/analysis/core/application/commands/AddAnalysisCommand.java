package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AddAnalysisCommand {
    private UUID id;

    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCard;

    private AddAnalysisCommand() {

    }

    public AddAnalysisCommand(UUID id, String name, String description, Integer executionTime, UUID medicalCard) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCard = medicalCard;
    }
}
