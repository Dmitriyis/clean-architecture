package com.course.cleanarchitecture.domain.analysis.adapters.in.http.dto;

import java.time.LocalDateTime;

public record AnalysisDtoGetByMedicalCardId(String name,
                                            String description,
                                            Integer executionTime,
                                            LocalDateTime timeAppointment) {

}
