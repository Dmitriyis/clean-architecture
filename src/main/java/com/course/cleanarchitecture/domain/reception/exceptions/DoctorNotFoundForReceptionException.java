package com.course.cleanarchitecture.domain.reception.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class DoctorNotFoundForReceptionException extends NotFoundException {
    public DoctorNotFoundForReceptionException(String message) {
        super(message);
    }
}
