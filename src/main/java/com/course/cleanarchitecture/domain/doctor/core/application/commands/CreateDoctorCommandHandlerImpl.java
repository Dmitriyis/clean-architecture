package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateDoctorCommandHandlerImpl implements CreateDoctorCommandHandler {

    private final DoctorRepository doctorRepository;

    @Override
    @Transactional
    public UUID execute(CreateDoctorCommand createPetCommand) {
        Doctor doctor = new Doctor(UUID.randomUUID(), createPetCommand.getName(), createPetCommand.getProfession(), createPetCommand.getWorkExperience(), null);

        return doctorRepository.save(doctor);
    }
}
