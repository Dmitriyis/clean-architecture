package com.course.cleanarchitecture.domain.doctor.exceptions;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;

public class DoctorInvalidFieldException extends InvalidFieldException {
    public DoctorInvalidFieldException(String message) {
        super(message);
    }
}
