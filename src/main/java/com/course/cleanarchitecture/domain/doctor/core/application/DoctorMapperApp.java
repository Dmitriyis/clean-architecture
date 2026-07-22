package com.course.cleanarchitecture.domain.doctor.core.application;

import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdResult;
import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorMapperApp {
    public GetDoctorByIdResult toGetDoctorByIdResult(Doctor doctor) {
        GetDoctorByIdResult getDoctorByIdResult = new GetDoctorByIdResult(
                doctor.getName(),
                doctor.getProfession(),
                doctor.getWorkExperience()
        );

        return getDoctorByIdResult;
    }
}
