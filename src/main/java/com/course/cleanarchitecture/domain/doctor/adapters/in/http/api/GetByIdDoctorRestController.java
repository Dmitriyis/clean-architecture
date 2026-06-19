package com.course.cleanarchitecture.domain.doctor.adapters.in.http.api;


import com.course.cleanarchitecture.domain.doctor.adapters.in.http.DoctorConstantsHttp;
import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdQuery;
import com.course.cleanarchitecture.domain.doctor.core.application.queries.GetDoctorByIdQueryHandler;
import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(DoctorConstantsHttp.ROOT_URL)
public class GetByIdDoctorRestController {

    private final GetDoctorByIdQueryHandler getDoctorByIdQueryHandler;

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable("id") UUID id) throws NoSuchFieldException {
        GetDoctorByIdQuery query = new GetDoctorByIdQuery(id);
        return getDoctorByIdQueryHandler.execute(query);
    }
}
