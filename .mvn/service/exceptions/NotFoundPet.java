package com.course.cleanarchitecture.entity.service.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class NotFoundPet extends NotFoundException {
    public NotFoundPet(String message) {
        super(message);
    }
}
