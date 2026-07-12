package com.course.cleanarchitecture.domain.doctor.adapters.out.postgres;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class DoctorJpaMapper {
    public DoctorEntity toDoctorEntity(Doctor doctor) {

        return DoctorEntity
                .builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .profession(doctor.getProfession())
                .workExperience(doctor.getWorkExperience())
                .build();
    }

    public Doctor toDoctor(DoctorEntity doctorEntity) {

        return new Doctor(
                doctorEntity.getId(),
                doctorEntity.getName(),
                doctorEntity.getProfession(),
                doctorEntity.getWorkExperience()
        );
    }
}
