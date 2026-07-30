package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.domain.doctor.core.application.DoctorMapperApp;
import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetDoctorByIdQueryHandlerImpl implements GetDoctorByIdQueryHandler {

    private final DoctorMapperApp doctorMapperApp;
    private final DoctorRepository doctorRepository;

    @Override
    public Optional<GetDoctorByIdResult> execute(GetDoctorByIdQuery query) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(query.getId());

        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            return doctorMapperApp.toGetDoctorByIdResult(doctor);
        } else {
            return Optional.empty();
        }
    }
}
