package com.course.cleanarchitecture.domain.pet.core.application.queries;

import lombok.Getter;

import java.util.UUID;

@Getter
public class GetPetByIdQuery {

    private UUID id;

    private GetPetByIdQuery() {
    }

    public GetPetByIdQuery(UUID id) {
        this.id = id;
    }
}