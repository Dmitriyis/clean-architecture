package com.course.cleanarchitecture.entity.pet.exceptions;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;

public class PetInvalidFieldException extends InvalidFieldException {
    public PetInvalidFieldException(String message) {
        super(message);
    }
}
