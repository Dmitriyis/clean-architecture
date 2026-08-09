package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.domain.doctor.core.application.DoctorMapperApp;
import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import com.course.cleanarchitecture.domain.doctor.exceptions.DoctorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetDoctorByIdQueryHandlerImpl implements GetDoctorByIdQueryHandler {

    private final DoctorMapperApp doctorMapperApp;
    private final DoctorRepository doctorRepository;

    @Override
    public GetDoctorByIdResult execute(GetDoctorByIdQuery query) {
        Doctor doctor = doctorRepository.findById(query.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("Doctor", "id", query.getId().toString());

                    return new DoctorNotFoundException(message);
                });

        return doctorMapperApp.toGetDoctorByIdResult(doctor);
    }
}
