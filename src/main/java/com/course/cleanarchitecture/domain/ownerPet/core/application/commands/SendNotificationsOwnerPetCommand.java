package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class SendNotificationsOwnerPetCommand {

    private UUID petId;

    private String message;

    private SendNotificationsOwnerPetCommand() {

    }

    public SendNotificationsOwnerPetCommand(UUID petId, String message) {
        ValidationValueUtils.againstNull(petId, "petId");
        ValidationValueUtils.againstNullOrEmpty(message, "message");
        this.petId = petId;
        this.message = message;
    }
}
