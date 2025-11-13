package com.course.cleanarchitecture.domain.analysis.service.mapper;

import com.course.cleanarchitecture.domain.analysis.service.dto.AnalysisRequestDto;
import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;

public class AnalysisMapper {
    public OwnerPetEntity toPetEntity(AnalysisRequestDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
