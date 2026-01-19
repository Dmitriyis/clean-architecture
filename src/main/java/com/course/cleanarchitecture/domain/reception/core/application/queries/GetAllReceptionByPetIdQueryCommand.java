package com.course.cleanarchitecture.domain.reception.core.application.queries;

import lombok.Getter;

import java.util.UUID;

@Getter
public class GetAllReceptionByPetIdQueryCommand {
    private UUID petId;

    public GetAllReceptionByPetIdQueryCommand() {
    }

    public GetAllReceptionByPetIdQueryCommand(UUID petId) {
        this.petId = petId;
    }
}
