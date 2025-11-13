package com.course.cleanarchitecture.domain.ownerPet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class OwnerPetNotFoundException extends NotFoundException {

    public OwnerPetNotFoundException(String message) {
        super(message);
    }
}
