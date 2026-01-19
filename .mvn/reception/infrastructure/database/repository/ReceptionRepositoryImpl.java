package com.course.cleanarchitecture.domain.reception.infrastructure.database.repository;

import com.course.cleanarchitecture.domain.reception.service.dto.ReceptionSearchParamsDto;
import com.course.cleanarchitecture.domain.reception.model.ReceptionRepository;
import com.course.cleanarchitecture.domain.reception.service.mapper.ReceptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ReceptionRepositoryImpl implements ReceptionRepository {

    private final ReceptionMapper receptionMapper;
    private final ReceptionRepositoryJpa receptionRepositoryJpa;

    @Override
    public UUID save(ReceptionEntity receptionEntity) {
        return receptionRepositoryJpa.save(receptionEntity).getId();
    }

    @Override
    public List<ReceptionEntity> findAllBySearchParams(ReceptionSearchParamsDto receptionSearchParamsDto) {
        ReceptionSearchParamsInfra petSearchParamsInfra = receptionMapper.toPetSearchParamsInfra(receptionSearchParamsDto);

        return receptionRepositoryJpa.findAll(petSearchParamsInfra);
    }

    @Override
    public Optional<ReceptionEntity> findById(UUID id) {
        return receptionRepositoryJpa.findById(id);
    }
}
