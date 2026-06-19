package com.course.cleanarchitecture.domain.doctor.adapters.out.postgres;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DoctorEntityMapper {
    public static DoctorEntity toDoctorEntity(Doctor doctor) {

        List<ReceptionEntity> receptionEntities = null;
        if (doctor.getReceptions() != null) {
            receptionEntities = doctor.getReceptions()
                    .stream()
                    .map(receptionId -> {
                        return ReceptionEntity
                                .builder()
                                .id(receptionId)
                                .build();
                    })
                    .toList();
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

    public static Doctor toDoctor(DoctorEntity doctorEntity) {
        List<UUID> receptionsId = new ArrayList<>();

        if (doctorEntity.getReceptions() != null) {
            receptionsId = doctorEntity.getReceptions()
                    .stream()
                    .map(ReceptionEntity::getId)
                    .collect(Collectors.toList());
        }

        return new Doctor(
                doctorEntity.getId(),
                doctorEntity.getName(),
                doctorEntity.getProfession(),
                doctorEntity.getWorkExperience(),
                receptionsId
        );
    }
}
