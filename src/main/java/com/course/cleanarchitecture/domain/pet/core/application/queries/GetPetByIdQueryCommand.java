package com.course.cleanarchitecture.domain.pet.core.application.queries;

import lombok.Getter;

import java.util.UUID;

@Getter
public class GetPetByIdQueryCommand {

    private UUID id;

    private GetPetByIdQueryCommand() {
    }

    public GetPetByIdQueryCommand(UUID id) {
        this.id = id;
    }
}


