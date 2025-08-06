package com.course.cleanarchitecture.entity.analysis.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisRequestDto {
    private String name;

    private Integer leadTime;

    private BigDecimal price;

    private String recommendations;
}
