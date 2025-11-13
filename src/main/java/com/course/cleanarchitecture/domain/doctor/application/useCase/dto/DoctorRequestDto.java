package com.course.cleanarchitecture.domain.doctor.application.useCase.dto;

import com.course.cleanarchitecture.domain.doctor.model.TypeProfession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDto {

    private String name;

    private TypeProfession profession;

    private Integer workExperience;
}
