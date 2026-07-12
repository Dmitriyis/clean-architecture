package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class SendNotificationsOwnerPetCommand {

    private UUID medicalCardId;

    private String message;

    private SendNotificationsOwnerPetCommand() {

    }

    public SendNotificationsOwnerPetCommand(UUID medicalCardId, String message) {
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");
        ValidationValueUtils.againstNullOrEmpty(message, "message");
        this.medicalCardId = medicalCardId;
        this.message = message;
    }
}
