package com.course.cleanarchitecture.entity.analysis.service.mapper;

import com.course.cleanarchitecture.entity.analysis.service.dto.AnalysisRequestDto;
import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;

public class AnalysisMapper {
    public OwnerPetEntity toPetEntity(AnalysisRequestDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
