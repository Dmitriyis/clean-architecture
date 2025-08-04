package com.course.cleanarchitecture.entity.ownerPet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class OwnerPetNotFoundException extends NotFoundException {

    public OwnerPetNotFoundException(String message) {
        super(message);
    }
}
