package com.course.cleanarchitecture.domain.reception.adapters.out.postgres;

import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceptionJpaMapper {
    public ReceptionEntity toReceptionEntity(Reception reception) {
        ReceptionEntity receptionEntity = ReceptionEntity
                .builder()
                .id(reception.getId())
                .petId(reception.getPetId())
                .doctorId(reception.getDoctorId())
                .analysesDirection(reception.getAnalysesDirection())
                .description(reception.getDescription())
                .startReception(reception.getStartReception())
                .endReception(reception.getEndReception())
                .build();

        return receptionEntity;
    }

    public Reception toReception(ReceptionEntity receptionEntity) {

        Reception reception = Reception.reStore(
                receptionEntity.getId(),
                receptionEntity.getPetId(),
                receptionEntity.getDoctorId(),
                receptionEntity.getAnalysesDirection(),
                receptionEntity.getDescription(),
                receptionEntity.getStartReception(),
                receptionEntity.getEndReception()
        );

        return reception;
    }

    public List<Reception> toReceptionList(List<ReceptionEntity> receptionsEntity) {
        List<Reception> receptions = receptionsEntity.stream()
                .map(this::toReception)
                .collect(Collectors.toList());

        return receptions;
    }
}

