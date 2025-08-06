package com.course.cleanarchitecture.entity.analysis.useCase.provider;

import java.util.UUID;

public interface DeleteAnalysisByIdProvider {
    UUID execute(UUID id);
}
