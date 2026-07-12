package com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto;

import java.util.UUID;


public record AnalysisDtoCreate(String name,
                                String description,
                                Integer executionTime,
                                UUID medicalCard) {

}
