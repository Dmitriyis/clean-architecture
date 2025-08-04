package com.course.cleanarchitecture.entity.analysis.service;

import com.course.cleanarchitecture.entity.analysis.service.dto.AnalysisRequestDto;
import com.course.cleanarchitecture.entity.analysis.service.mapper.AnalysisMapper;
import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.PetRepository;
import com.course.cleanarchitecture.entity.pet.model.useCase.PetSaveUseCase;

import java.util.UUID;

public class AnalysisSaveUseCaseImpl implements PetSaveUseCase {

    private PetRepository petRepository;
    private AnalysisMapper petMapper;

    @Override
    public UUID save(AnalysisRequestDto petRequestDto) {
        OwnerPetEntity petEntity = petMapper.toPetEntity(petRequestDto);
        return petRepository.save(petEntity);
    }
}
