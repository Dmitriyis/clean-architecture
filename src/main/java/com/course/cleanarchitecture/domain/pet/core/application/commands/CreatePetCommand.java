package com.course.cleanarchitecture.domain.pet.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreatePetCommand {

    private Integer age;

    private String name;

    private Integer weight;

    private UUID ownerPetId;

    private CreatePetCommand() {

    }

    public CreatePetCommand(Integer age, String name, Integer weight, UUID ownerPetId) {
        ValidationValueUtils.againstNull(age, "age");
        ValidationValueUtils.againstNull(weight, "weight");
        ValidationValueUtils.againstNegative(weight, "weight");
        ValidationValueUtils.againstNegative(age, "age");
        ValidationValueUtils.againstNull(ownerPetId, "ownerPetId");
        ValidationValueUtils.againstNullOrEmpty(name, "name");

        this.age = age;
        this.name = name;
        this.weight = weight;
        this.ownerPetId = ownerPetId;
    }
}
