package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.pet.core.model.MedicalCard;
import org.springframework.stereotype.Service;

@Service
public class MedicalCardJpaMapper {
    public MedicalCardEntity toMedicalCardEntity(MedicalCard medicalCard) {
        MedicalCardEntity medicalCardEntity = MedicalCardEntity
                .builder()
                .id(medicalCard.getId())
                .createTime(medicalCard.getCreateTime())
                .updateTime(medicalCard.getUpdateTime())
                .build();

        return medicalCardEntity;
    }

    public MedicalCard toMedicalCard(MedicalCardEntity medicalCardEntity) {
        MedicalCard medicalCard = MedicalCard.reStore(
                medicalCardEntity.getId(),
                medicalCardEntity.getCreateTime(),
                medicalCardEntity.getUpdateTime()
        );

        return medicalCard;
    }
}
