package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.analysis.adapters.out.AnalysisEntity;
import com.course.cleanarchitecture.domain.pet.core.model.MedicalCard;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionEntity;

import java.util.List;

public class MedicalCardEntityToMedicalCardMapper {
    public static MedicalCardEntity medicalCardToMedicalCardEntity(MedicalCard medicalCard) {

        List<ReceptionEntity> receptionEntities = null;
        if (medicalCard.getReceptionsId() != null) {
            receptionEntities = medicalCard.getReceptionsId()
                    .stream()
                    .map(receptionId -> {
                        return ReceptionEntity
                                .builder()
                                .id(receptionId)
                                .build();
                    }).toList();
        }

        List<AnalysisEntity> analysis = null;
        if (medicalCard.getAnalyses() != null) {
            analysis = medicalCard.getAnalyses()
                    .stream()
                    .map(analysesId -> {
                        return AnalysisEntity
                                .builder()
                                .id(analysesId)
                                .build();
                    }).toList();
        }

        MedicalCardEntity medicalCardEntity = MedicalCardEntity
                .builder()
                .id(medicalCard.getId())
                .updateTime(medicalCard.getUpdateTime())
                .build();

        medicalCardEntity.setAnalysis(analysis);
        medicalCardEntity.setReception(receptionEntities);

        return medicalCardEntity;
    }
}
