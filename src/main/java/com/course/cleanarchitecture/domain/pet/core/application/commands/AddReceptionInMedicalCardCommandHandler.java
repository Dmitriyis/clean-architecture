package com.course.cleanarchitecture.domain.pet.core.application.commands;

import java.util.UUID;

public interface AddReceptionInMedicalCardCommandHandler {
    void execute(AddReceptionInMedicalCardCommand addReceptionInMedicalCardCommand) throws NoSuchFieldException;
}
