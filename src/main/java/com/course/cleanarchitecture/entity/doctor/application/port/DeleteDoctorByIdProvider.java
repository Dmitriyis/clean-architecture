package com.course.cleanarchitecture.entity.doctor.application.port;

import java.util.UUID;

public interface DeleteDoctorByIdProvider {
    UUID execute(UUID id);
}
