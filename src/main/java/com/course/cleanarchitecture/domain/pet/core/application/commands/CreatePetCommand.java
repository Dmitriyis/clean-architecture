package com.course.cleanarchitecture.domain.pet.core.application.commands;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreatePetCommand {

    private Integer age;

    private String name;

    private Double weight;

    private UUID ownerPetId;

    private CreatePetCommand() {

    }

    public CreatePetCommand(Integer age, String name, Double weight, UUID ownerPetId) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.ownerPetId = ownerPetId;
    }
}
