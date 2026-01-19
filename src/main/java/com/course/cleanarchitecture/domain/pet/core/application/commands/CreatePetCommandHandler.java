package com.course.cleanarchitecture.domain.pet.core.application.commands;

import com.course.cleanarchitecture.domain.pet.core.model.Pet;

import java.util.UUID;

public interface CreatePetCommandHandler {
    UUID execute(CreatePetCommand createPetCommand);
}
