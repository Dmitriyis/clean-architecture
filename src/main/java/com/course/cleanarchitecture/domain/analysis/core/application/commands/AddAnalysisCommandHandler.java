package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import java.util.UUID;

public interface AddAnalysisCommandHandler {
    UUID execute(AddAnalysisCommand addAnalysisCommand) throws NoSuchFieldException;
}
