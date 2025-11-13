package com.course.cleanarchitecture.domain.reception.service.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class ReceptionNotFound extends NotFoundException {

    public ReceptionNotFound(String message) {
        super(message);
    }
}
