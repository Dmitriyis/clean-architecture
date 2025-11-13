package com.course.cleanarchitecture.domain.medicalRecord.exceptions;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;

public class NotFoundPet extends NotFoundException {
    public NotFoundPet(String message) {
        super(message);
    }
}
