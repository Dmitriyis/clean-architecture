package com.course.cleanarchitecture.entity.deiver.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class DriverNotFoundException extends NotFoundException {
    public DriverNotFoundException(String message) {
        super(message);
    }
}
