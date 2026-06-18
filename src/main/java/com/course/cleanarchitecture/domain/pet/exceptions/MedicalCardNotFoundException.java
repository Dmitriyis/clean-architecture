package com.course.cleanarchitecture.domain.pet.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class MedicalCardNotFoundException extends NotFoundException  {
    public MedicalCardNotFoundException(String message) {
        super(message);
    }
}
