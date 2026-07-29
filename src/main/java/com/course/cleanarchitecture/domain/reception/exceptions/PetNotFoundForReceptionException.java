package com.course.cleanarchitecture.domain.reception.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class PetNotFoundForReceptionException extends NotFoundException {
    public PetNotFoundForReceptionException(String message) {
        super(message);
    }
}
