package com.course.cleanarchitecture.domain.ownerPet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class OwnerPetMedicalCardNotFoundException extends NotFoundException  {
    public OwnerPetMedicalCardNotFoundException(String message) {
        super(message);
    }
}
