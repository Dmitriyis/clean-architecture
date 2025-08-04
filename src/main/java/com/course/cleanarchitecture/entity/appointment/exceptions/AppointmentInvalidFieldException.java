package com.course.cleanarchitecture.entity.appointment.exceptions;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;

public class AppointmentInvalidFieldException extends InvalidFieldException {
    public AppointmentInvalidFieldException(String message) {
        super(message);
    }
}
