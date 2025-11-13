package com.course.cleanarchitecture.domain.ownerPet.exceptions;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;

public class OwnerPetInvalidFieldException extends InvalidFieldException {
    public OwnerPetInvalidFieldException(String message) {
        super(message);
    }
}
