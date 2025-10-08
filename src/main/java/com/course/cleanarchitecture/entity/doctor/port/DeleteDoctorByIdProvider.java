package com.course.cleanarchitecture.entity.doctor.port;

import java.util.UUID;

public interface DeleteDoctorByIdProvider {
    UUID execute(UUID id);
}
