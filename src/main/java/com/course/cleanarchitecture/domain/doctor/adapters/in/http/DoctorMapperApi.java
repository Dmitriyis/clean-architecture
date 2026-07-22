package com.course.cleanarchitecture.domain.doctor.adapters.in.http;

import com.course.cleanarchitecture.domain.doctor.adapters.in.http.dto.DoctorGetByIdResponse;
import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdResult;
import org.springframework.stereotype.Service;

@Service
public class DoctorMapperApi {
    public DoctorGetByIdResponse toDoctorGetByIdResponse(GetDoctorByIdResult getDoctorByIdResult) {
        DoctorGetByIdResponse doctorGetByIdResponse = new DoctorGetByIdResponse(
                getDoctorByIdResult.name(),
                getDoctorByIdResult.profession(),
                getDoctorByIdResult.workExperience()
        );

        return doctorGetByIdResponse;
    }
}
