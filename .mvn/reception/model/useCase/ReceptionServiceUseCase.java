package com.course.cleanarchitecture.entity.reception.model.useCase;

import com.course.cleanarchitecture.entity.reception.service.dto.ReceptionRequestDto;
import com.course.cleanarchitecture.entity.reception.service.dto.ReceptionSearchParamsDto;
import com.course.cleanarchitecture.entity.reception.model.ReceptionEntity;

import java.util.List;
import java.util.UUID;

public interface ReceptionServiceUseCase {
    UUID save(ReceptionRequestDto receptionRequestDto);

    List<ReceptionEntity> findAllBySearchParams(ReceptionSearchParamsDto receptionSearchParamsDto);

}
