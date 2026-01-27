package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDoctorByIdCommandHandlerImpl implements GetDoctorByIdCommandHandler {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor execute(GetDoctorByIdCommand getDoctorByIdCommand) throws NoSuchFieldException {
        return doctorRepository.findById(getDoctorByIdCommand.getId());
    }
}
