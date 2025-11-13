package com.course.cleanarchitecture.domain.reception.model;

import com.course.cleanarchitecture.domain.reception.service.dto.ReceptionSearchParamsDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReceptionRepository {
    UUID save(ReceptionEntity reception);

    List<ReceptionEntity> findAllBySearchParams(ReceptionSearchParamsDto receptionSearchParamsDto);

    Optional<ReceptionEntity> findById(UUID id);
}
