package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import java.util.UUID;

public interface CreateDoctorCommandHandler {
    UUID execute(CreateDoctorCommand createDoctorCommand);
}
