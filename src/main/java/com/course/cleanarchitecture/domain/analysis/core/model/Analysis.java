package com.course.cleanarchitecture.domain.analysis.core.model;

import com.course.cleanarchitecture.ddd.Aggregate;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Analysis extends Aggregate<UUID> {

    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCardId;

    private Analysis() {
    }

    public Analysis(UUID id, String name, String description, Integer executionTime, UUID medicalCardId) {
        //
        super(id);
        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCardId = medicalCardId;
    }
}
