package com.course.cleanarchitecture.domain.reception.adapters.out.postgres;

import com.course.cleanarchitecture.domain.doctor.adapters.out.postgres.DoctorEntity;
import com.course.cleanarchitecture.domain.pet.adapters.out.postgres.MedicalCardEntity;
import com.course.cleanarchitecture.domain.reception.core.model.Reception;

public class ReceptionToReceptionEntityMapper {
    public static ReceptionEntity receptionToReceptionEntity(Reception reception) {
        MedicalCardEntity medicalCardEntity = MedicalCardEntity
                .builder()
                .id(reception.getMedicalCardId())
                .build();

        DoctorEntity doctorEntity = DoctorEntity
                .builder()
                .id(reception.getDoctorId())
                .build();

        return ReceptionEntity
                .builder()
                .id(reception.getId())
                .medicalCard(medicalCardEntity)
                .doctor(doctorEntity)
                .analyses(reception.getAnalyses())
                .conclusions(reception.getConclusions())
                .startReception(reception.getStartReception())
                .endReception(reception.getEndReception())
                .build();
    }
}
