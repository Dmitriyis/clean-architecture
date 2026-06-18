package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetAllAnalysisByMedicalCardIdResponse {
    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCardId;

    private LocalDateTime timeAppointment;
}
