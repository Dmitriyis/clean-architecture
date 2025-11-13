package com.course.cleanarchitecture.domain.doctor.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class DoctorNotFoundException extends NotFoundException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
