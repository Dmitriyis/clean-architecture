package com.course.cleanarchitecture.domain.transportOrder.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class TransportOrderNotFoundException extends NotFoundException {
    public TransportOrderNotFoundException(String message) {
        super(message);
    }
}
