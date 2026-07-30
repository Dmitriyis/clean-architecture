package com.course.cleanarchitecture.domain.pet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class PetOwnerPetNotFoundException extends NotFoundException {
    public PetOwnerPetNotFoundException(String message) {
        super(message);
    }
}
