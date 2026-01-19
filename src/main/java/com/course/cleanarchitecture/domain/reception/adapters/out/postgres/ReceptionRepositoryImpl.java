package com.course.cleanarchitecture.domain.reception.adapters.out.postgres;

import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import com.course.cleanarchitecture.domain.reception.core.ports.ReceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionToReceptionEntityMapper.receptionToReceptionEntity;

@Repository
@RequiredArgsConstructor
public class ReceptionRepositoryImpl implements ReceptionRepository {

    private final ReceptionRepositoryJpa receptionRepositoryJpa;

    @Override
    public UUID save(Reception reception) {
        ReceptionEntity receptionEntity = receptionToReceptionEntity(reception);
        receptionRepositoryJpa.save(receptionEntity);
        return receptionEntity.getId();
    }

    @Override
    public List<Reception> findAllByPetId(UUID petId) {
        List<ReceptionEntity> receptionEntities = receptionRepositoryJpa.findAllByPetId(petId);

        List<Reception> receptions = receptionEntities
                .stream()
                .map(receptionEntity -> {
                    return Reception.reStore(receptionEntity.getId(), receptionEntity.getMedicalCard().getId(), receptionEntity.getDoctor().getId(), receptionEntity.getAnalyses(), receptionEntity.getConclusions(), receptionEntity.getStartReception(), receptionEntity.getEndReception());
                }).toList();
        return receptions;
    }
}
