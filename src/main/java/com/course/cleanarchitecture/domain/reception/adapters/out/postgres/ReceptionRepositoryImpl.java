package com.course.cleanarchitecture.domain.reception.adapters.out.postgres;

import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import com.course.cleanarchitecture.domain.reception.core.ports.ReceptionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ReceptionRepositoryImpl implements ReceptionRepository {

    private final ReceptionJpaMapper receptionJpaMapper;
    private final ReceptionRepositoryJpa receptionRepositoryJpa;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public UUID save(Reception reception) {
        ReceptionEntity receptionEntity = receptionJpaMapper.toReceptionEntity(reception);

        receptionRepositoryJpa.save(receptionEntity);

        return receptionEntity.getId();
    }

    @Override
    public List<Reception> findAllByPetId(UUID petId) {
        List<ReceptionEntity> receptionEntities = receptionRepositoryJpa.findAllByPetId(petId);

        List<Reception> receptionList = receptionJpaMapper.toReceptionList(receptionEntities);

        return receptionList;
    }
}
