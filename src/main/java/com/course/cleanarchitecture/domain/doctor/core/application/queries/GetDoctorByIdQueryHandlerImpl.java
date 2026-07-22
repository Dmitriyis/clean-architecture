package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.domain.doctor.core.application.DoctorMapperApp;
import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import com.course.cleanarchitecture.domain.doctor.exceptions.DoctorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDoctorByIdQueryHandlerImpl implements GetDoctorByIdQueryHandler {

    private final DoctorMapperApp doctorMapperApp;
    private final DoctorRepository doctorRepository;

    @Override
    public GetDoctorByIdResult execute(GetDoctorByIdQuery query) {
        Doctor doctor = doctorRepository.findById(query.getId())
                .orElseThrow(() -> new DoctorNotFoundException("Not found Doctor by id: " + query.getId() + "."));

        return doctorMapperApp.toGetDoctorByIdResult(doctor);
    }

}
