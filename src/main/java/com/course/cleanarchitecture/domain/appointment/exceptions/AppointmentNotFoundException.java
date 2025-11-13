package com.course.cleanarchitecture.domain.appointment.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class AppointmentNotFoundException extends NotFoundException {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
