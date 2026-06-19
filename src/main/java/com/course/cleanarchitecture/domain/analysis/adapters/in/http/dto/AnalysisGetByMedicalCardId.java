package com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisGetByMedicalCardId {
    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCardId;

    private LocalDateTime timeAppointment;
}
