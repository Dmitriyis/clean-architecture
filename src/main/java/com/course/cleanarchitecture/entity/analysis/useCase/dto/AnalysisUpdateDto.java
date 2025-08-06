package com.course.cleanarchitecture.entity.analysis.useCase.dto;

import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisUpdateDto {

    private UUID id;

    private String name;

    private Integer leadTime;

    private BigDecimal price;

    private String recommendations;
}
