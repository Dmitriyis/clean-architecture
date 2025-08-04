package com.course.cleanarchitecture.entity.reception.service.mapper;

import com.course.cleanarchitecture.entity.reception.service.dto.ReceptionRequestDto;
import com.course.cleanarchitecture.entity.reception.service.dto.ReceptionSearchParamsDto;
import com.course.cleanarchitecture.entity.reception.service.dto.ReceptionUpdateDto;
import com.course.cleanarchitecture.entity.reception.infrastructure.database.repository.ReceptionSearchParamsInfra;
import com.course.cleanarchitecture.entity.reception.model.ReceptionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReceptionMapper {
    ReceptionEntity toReceptionEntity(ReceptionRequestDto receptionRequestDto);
    ReceptionEntity toReceptionEntity(ReceptionUpdateDto receptionUpdateDto);

    ReceptionSearchParamsInfra toPetSearchParamsInfra(ReceptionSearchParamsDto receptionSearchParamsDto);
}
