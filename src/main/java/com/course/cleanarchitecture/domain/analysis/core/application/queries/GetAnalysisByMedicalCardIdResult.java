package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetAnalysisByMedicalCardIdResult {
    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCardId;

    private LocalDateTime timeAppointment;
}
