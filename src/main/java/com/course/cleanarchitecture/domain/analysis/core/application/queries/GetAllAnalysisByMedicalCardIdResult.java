package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetAllAnalysisByMedicalCardIdResult(UUID id,
                                                  String name,
                                                  String description,
                                                  Integer executionTime,
                                                  LocalDateTime createTime) {

}
