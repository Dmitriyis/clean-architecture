package com.course.cleanarchitecture.domain.analysis.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class AnalysisNotFound extends NotFoundException {
    public AnalysisNotFound(String message) {
        super(message);
    }
}
