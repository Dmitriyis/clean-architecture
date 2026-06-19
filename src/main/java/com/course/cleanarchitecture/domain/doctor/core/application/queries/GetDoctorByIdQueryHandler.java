package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;

public interface GetDoctorByIdQueryHandler {
    Doctor execute(GetDoctorByIdQuery getDoctorByIdQuery);
}
