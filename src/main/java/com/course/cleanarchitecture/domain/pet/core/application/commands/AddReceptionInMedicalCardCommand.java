package com.course.cleanarchitecture.domain.pet.core.application.commands;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AddReceptionInMedicalCardCommand {
    private UUID medicalCardId;
    private UUID receptionId;

    private AddReceptionInMedicalCardCommand() {

    }

    public AddReceptionInMedicalCardCommand(UUID medicalCardId, UUID receptionId) {
        this.medicalCardId = medicalCardId;
        this.receptionId = receptionId;
    }
}
