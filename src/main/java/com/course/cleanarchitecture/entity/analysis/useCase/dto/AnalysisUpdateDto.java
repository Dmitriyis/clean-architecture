package com.course.cleanarchitecture.entity.analysis.useCase.dto;

import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisUpdateDto {
    private UUID id;

    private String name;

    private TypeProfession profession;

    private Integer workExperience;
}
