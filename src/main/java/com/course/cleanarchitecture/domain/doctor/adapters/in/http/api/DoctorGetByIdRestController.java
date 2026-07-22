package com.course.cleanarchitecture.domain.doctor.adapters.in.http.api;


import com.course.cleanarchitecture.domain.doctor.adapters.in.http.DoctorConstantsHttp;
import com.course.cleanarchitecture.domain.doctor.adapters.in.http.DoctorMapperApi;
import com.course.cleanarchitecture.domain.doctor.adapters.in.http.dto.DoctorGetByIdResponse;
import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdQuery;
import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdQueryHandler;
import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(DoctorConstantsHttp.ROOT_URL)
public class DoctorGetByIdRestController {

    private final DoctorMapperApi doctorMapperApi;
    private final GetDoctorByIdQueryHandler getDoctorByIdQueryHandler;

    @GetMapping("/{id}")
    public DoctorGetByIdResponse getDoctor(@PathVariable("id") UUID id) {
        GetDoctorByIdQuery query = new GetDoctorByIdQuery(id);
        GetDoctorByIdResult doctorResult = getDoctorByIdQueryHandler.execute(query);

        return doctorMapperApi.toDoctorGetByIdResponse(doctorResult);
    }
}
