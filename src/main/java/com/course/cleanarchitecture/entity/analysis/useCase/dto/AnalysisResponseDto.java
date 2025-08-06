package com.course.cleanarchitecture.entity.analysis.useCase.dto;

import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResponseDto {

    private UUID id;

    private String name;

    private Integer leadTime;

    private BigDecimal price;

    private String recommendations;
}
