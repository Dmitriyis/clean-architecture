package com.course.cleanarchitecture.entity.reception.service;

import com.course.cleanarchitecture.entity.reception.service.dto.ReceptionRequestDto;
import com.course.cleanarchitecture.entity.reception.service.dto.ReceptionSearchParamsDto;
import com.course.cleanarchitecture.entity.reception.model.ReceptionEntity;
import com.course.cleanarchitecture.entity.reception.model.ReceptionRepository;
import com.course.cleanarchitecture.entity.reception.model.useCase.ReceptionServiceUseCase;
import com.course.cleanarchitecture.entity.reception.service.mapper.ReceptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceptionApplicationServiceImpl implements ReceptionServiceUseCase {

    private final ReceptionMapper receptionMapper;
    private final ReceptionRepository receptionRepository;

    @Override
    public UUID save(ReceptionRequestDto receptionRequestDto) {
        ReceptionEntity receptionEntity = receptionMapper.toReceptionEntity(receptionRequestDto);
        return receptionRepository.save(receptionEntity);
    }

    @Override
    public List<ReceptionEntity> findAllBySearchParams(ReceptionSearchParamsDto receptionSearchParamsDto) {
        return receptionRepository.findAllBySearchParams(receptionSearchParamsDto);
    }
}
