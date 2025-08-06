package com.course.cleanarchitecture.entity.appointment.model;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.pet.model.PetEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class GenerateAppointmentEntity {

    public static AppointmentEntity generate(UUID id, UUID petId, UUID doctorId, List<UUID> analysisId) {
        PetEntity petEntity = new PetEntity(petId, null, null, null, null, null, null);
        DoctorEntity doctorEntity = new DoctorEntity(doctorId, null, null, null, null);
        List<AnalysisEntity> analysisEntitys = getAnalysisEntity(analysisId);

        AppointmentEntity appointmentEntity = new AppointmentEntity(id, petEntity, doctorEntity, analysisEntitys, LocalDateTime.now());
        return appointmentEntity;
    }

    private static List<AnalysisEntity> getAnalysisEntity(List<UUID> analysisIds) {
        return analysisIds.stream()
                .map(analysisId -> {
                    AnalysisEntity analysisEntity = new AnalysisEntity(analysisId, null, null, null, null);
                    return analysisEntity;
                })
                .toList();
    }
}
