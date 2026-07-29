package com.course.cleanarchitecture.domain.analysis.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class MedicalCardNotFoundForAnalysisException extends NotFoundException {
    public MedicalCardNotFoundForAnalysisException(String message) {
        super(message);
    }
}
