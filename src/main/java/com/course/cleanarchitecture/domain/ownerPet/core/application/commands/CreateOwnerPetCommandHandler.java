package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import java.util.UUID;

public interface CreateOwnerPetCommandHandler {
    UUID execute(CreateOwnerPetCommand command);
}
