package com.course.cleanarchitecture.domain.doctor.adapters.out.postgres;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionEntity;

import java.util.List;

public class DoctorToDoctorEntityMapper {
    public static DoctorEntity doctorToDoctorEntity(Doctor doctor) {

        List<ReceptionEntity> receptionEntities = null;
        if (doctor.getReceptions() != null) {
            receptionEntities = doctor.getReceptions().stream().map(receptionId -> {
                return ReceptionEntity
                        .builder()
                        .id(receptionId)
                        .build();
            }).toList();
        }

        return DoctorEntity
                .builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .profession(doctor.getProfession())
                .workExperience(doctor.getWorkExperience())
                .receptions(receptionEntities)
                .build();
    }
}
