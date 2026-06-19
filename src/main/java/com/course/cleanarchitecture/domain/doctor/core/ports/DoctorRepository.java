package com.course.cleanarchitecture.domain.doctor.core.ports;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;

import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository {
    UUID save(Doctor doctor);

    Optional<Doctor> findById(UUID id);
}
