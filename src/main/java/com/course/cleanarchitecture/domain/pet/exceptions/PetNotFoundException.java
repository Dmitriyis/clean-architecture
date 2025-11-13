package com.course.cleanarchitecture.domain.pet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class PetNotFoundException extends NotFoundException {

    public PetNotFoundException(String message) {
        super(message);
    }
}
