package com.course.cleanarchitecture.domain.analysis.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class AnalysisNotFoundException extends NotFoundException {
    public AnalysisNotFoundException(String message) {
        super(message);
    }
}
