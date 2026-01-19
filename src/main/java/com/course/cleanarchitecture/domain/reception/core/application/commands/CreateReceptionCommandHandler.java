package com.course.cleanarchitecture.domain.reception.core.application.commands;

import java.util.UUID;

public interface CreateReceptionCommandHandler {
    UUID execute(CreateReceptionCommand createPetCommand);
}
