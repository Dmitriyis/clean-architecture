package com.course.cleanarchitecture.domain.doctor.adapters.in.http;

import com.course.cleanarchitecture.domain.doctor.adapters.in.http.dto.DoctorGetByIdResponse;
import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorMapperApi {
    public DoctorGetByIdResponse toDoctorGetByIdResponse(@NotNull Optional<GetDoctorByIdResult> getDoctorByIdResultOptional) {

        if (getDoctorByIdResultOptional.isEmpty()) {
            return null;
        }

        GetDoctorByIdResult getDoctorByIdResult = getDoctorByIdResultOptional.get();

        DoctorGetByIdResponse doctorGetByIdResponse = new DoctorGetByIdResponse(
                getDoctorByIdResult.name(),
                getDoctorByIdResult.profession(),
                getDoctorByIdResult.workExperience()
        );

        return doctorGetByIdResponse;
    }
}
