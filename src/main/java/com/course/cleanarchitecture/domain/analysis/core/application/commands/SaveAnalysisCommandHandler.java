package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import java.util.UUID;

public interface SaveAnalysisCommandHandler {
    UUID execute(SaveAnalysisCommand addAnalysisCommand);
}
