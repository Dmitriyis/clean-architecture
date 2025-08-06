package com.course.cleanarchitecture.entity.analysis.useCase;

import java.util.UUID;

public interface DeleteAnalysisByIdUseCase {
    UUID execute(UUID id);
}
