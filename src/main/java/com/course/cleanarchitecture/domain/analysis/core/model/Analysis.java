package com.course.cleanarchitecture.domain.analysis.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.Aggregate;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Analysis extends Aggregate<UUID> {

    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCardId;

    private LocalDateTime createDate;

    private Analysis() {
    }

    public Analysis(UUID id, String name, String description, Integer executionTime, UUID medicalCardId, LocalDateTime createDate) {
        super(id);

        ValidationValueUtils.againstNull(id, "id");
        ValidationValueUtils.againstNull(name, "name");
        ValidationValueUtils.againstNull(description, "description");
        ValidationValueUtils.againstNull(executionTime, "executionTime");
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");

        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCardId = medicalCardId;
        this.createDate = createDate;
    }

    public static Analysis reStore(UUID id, String name, String description, Integer executionTime, UUID medicalCardId, LocalDateTime createDate) {
        return new Analysis(id, name, description, executionTime, medicalCardId, createDate);
    }
}
