package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddReceptionInDoctorCommandHandlerImpl implements AddReceptionInDoctorCommandHandler {

    private final DoctorRepository doctorRepository;

    @Override
    @Transactional
    public void execute(AddReceptionInDoctorCommand addReceptionInMedicalCardCommand) throws NoSuchFieldException {
        Doctor doctor = doctorRepository.findById(addReceptionInMedicalCardCommand.getDoctorId());

        doctor.addReception(addReceptionInMedicalCardCommand.getReceptionId());

        doctorRepository.save(doctor);
    }
}
