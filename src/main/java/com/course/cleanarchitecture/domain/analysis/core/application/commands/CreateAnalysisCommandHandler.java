package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import java.util.UUID;

public interface CreateAnalysisCommandHandler {
    UUID execute(CreateAnalysisCommand command);
}
