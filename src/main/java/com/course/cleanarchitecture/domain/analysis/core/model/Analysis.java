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

    private LocalDateTime appointmentTime;

    private Analysis() {
    }

    private Analysis(UUID id, String name, String description, Integer executionTime, UUID medicalCardId, LocalDateTime appointmentTime) {
        super(id);
        this.name = name;
        this.description = description;
        this.executionTime = executionTime;
        this.medicalCardId = medicalCardId;
        this.appointmentTime = appointmentTime;
    }

    public static Analysis create(UUID id, String name, String description, Integer executionTime, UUID medicalCardId, LocalDateTime timeAppointment) {
        ValidationValueUtils.againstNull(id, "id");
        ValidationValueUtils.againstNullOrEmpty(name, "name");
        ValidationValueUtils.againstNullOrEmpty(description, "description");
        ValidationValueUtils.againstNull(executionTime, "executionTime");
        ValidationValueUtils.againstNegative(executionTime, "executionTime");
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");

        return new Analysis(id, name, description, executionTime, medicalCardId, timeAppointment);
    }

    public static Analysis reStore(UUID id, String name, String description, Integer executionTime, UUID medicalCardId, LocalDateTime timeAppointment) {
        return new Analysis(id, name, description, executionTime, medicalCardId, timeAppointment);
    }
}
