package com.course.cleanarchitecture.domain.analysis.exceptions;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;

public class AnalysisInvalidFieldException extends InvalidFieldException {
    public AnalysisInvalidFieldException(String message) {
        super(message);
    }
}
