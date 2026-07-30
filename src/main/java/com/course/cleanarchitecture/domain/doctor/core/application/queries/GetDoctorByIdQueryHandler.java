package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;

import java.util.Optional;

public interface GetDoctorByIdQueryHandler {
    Optional<GetDoctorByIdResult> execute(GetDoctorByIdQuery query);
}
