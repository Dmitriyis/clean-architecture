package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AddReceptionInDoctorCommand {
    private UUID receptionId;
    private UUID doctorId;

    private AddReceptionInDoctorCommand() {

    }

    public AddReceptionInDoctorCommand(UUID receptionId, UUID doctorId) {
        this.receptionId = receptionId;
        this.doctorId = doctorId;
    }
}
