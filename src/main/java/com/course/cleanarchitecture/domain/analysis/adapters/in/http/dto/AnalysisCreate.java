package com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class AnalysisCreate {

    private String name;

    private String description;

    private Integer executionTime;

    private UUID medicalCard;
}
