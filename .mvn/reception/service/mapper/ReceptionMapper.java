package com.course.cleanarchitecture.domain.reception.service.mapper;

import com.course.cleanarchitecture.domain.reception.service.dto.ReceptionRequestDto;
import com.course.cleanarchitecture.domain.reception.service.dto.ReceptionSearchParamsDto;
import com.course.cleanarchitecture.domain.reception.service.dto.ReceptionUpdateDto;
import com.course.cleanarchitecture.domain.reception.infrastructure.database.repository.ReceptionSearchParamsInfra;
import com.course.cleanarchitecture.domain.reception.model.ReceptionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReceptionMapper {
    ReceptionEntity toReceptionEntity(ReceptionRequestDto receptionRequestDto);
    ReceptionEntity toReceptionEntity(ReceptionUpdateDto receptionUpdateDto);

    ReceptionSearchParamsInfra toPetSearchParamsInfra(ReceptionSearchParamsDto receptionSearchParamsDto);
}
