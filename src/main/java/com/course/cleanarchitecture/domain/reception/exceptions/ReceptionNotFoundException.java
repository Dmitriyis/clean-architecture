package com.course.cleanarchitecture.domain.reception.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class ReceptionNotFoundException extends NotFoundException {
    public ReceptionNotFoundException(String message) {
        super(message);
    }
}
