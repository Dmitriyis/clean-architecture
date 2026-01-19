package com.course.cleanarchitecture.domain.reception.exceptions;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;

public class ReceptionInvalidFieldException extends InvalidFieldException {
    public ReceptionInvalidFieldException(String message) {
        super(message);
    }
}
