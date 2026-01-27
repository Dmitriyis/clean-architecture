package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class SendNotificationsOwnerPetCommand {

    private UUID medicalCardId;

    private SendNotificationsOwnerPetCommand() {

    }

    public SendNotificationsOwnerPetCommand(UUID medicalCardId) {
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");
        this.medicalCardId = medicalCardId;
    }
}
