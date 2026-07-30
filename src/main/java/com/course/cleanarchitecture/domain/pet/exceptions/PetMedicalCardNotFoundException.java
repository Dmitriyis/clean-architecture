package com.course.cleanarchitecture.domain.pet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class PetMedicalCardNotFoundException extends NotFoundException  {
    public PetMedicalCardNotFoundException(String message) {
        super(message);
    }
}
