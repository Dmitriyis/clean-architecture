package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.domain.pet.core.application.commands.CreatePetCommand;

import java.util.UUID;

public interface CreateOwnerPetCommandHandler {
    UUID execute(CreateOwnerPetCommand createOwnerPetCommand);
}
