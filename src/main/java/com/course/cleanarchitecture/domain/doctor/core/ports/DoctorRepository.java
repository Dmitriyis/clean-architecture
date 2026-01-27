package com.course.cleanarchitecture.domain.doctor.core.ports;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;

import java.util.UUID;

public interface DoctorRepository {
    UUID save(Doctor doctor);

    Doctor findById(UUID id);
}
