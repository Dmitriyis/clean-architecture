package com.course.cleanarchitecture.entity.analysis.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class AnalysisNotFound extends NotFoundException {
    public AnalysisNotFound(String message) {
        super(message);
    }
}
