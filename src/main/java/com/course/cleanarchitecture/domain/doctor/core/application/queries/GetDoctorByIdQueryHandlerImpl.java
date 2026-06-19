package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetDoctorByIdQueryHandlerImpl implements GetDoctorByIdQueryHandler {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor execute(GetDoctorByIdQuery query) {
        return doctorRepository.findById(query.getId())
                .orElseThrow(() -> new NoSuchElementException("Not found Doctor by id: " + query.getId() + "."));
    }

}
