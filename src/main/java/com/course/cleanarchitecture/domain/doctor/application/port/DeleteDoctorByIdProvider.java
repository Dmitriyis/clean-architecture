package com.course.cleanarchitecture.domain.doctor.application.port;

import java.util.UUID;

public interface DeleteDoctorByIdProvider {
    UUID execute(UUID id);
}
