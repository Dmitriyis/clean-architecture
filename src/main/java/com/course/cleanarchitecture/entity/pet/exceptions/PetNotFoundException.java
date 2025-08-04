package com.course.cleanarchitecture.entity.pet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class PetNotFoundException extends NotFoundException {

    public PetNotFoundException(String message) {
        super(message);
    }
}
