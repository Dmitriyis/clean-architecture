package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;

public interface GetDoctorByIdCommandHandler {
    Doctor execute(GetDoctorByIdCommand getDoctorByIdCommand) throws NoSuchFieldException;
}
