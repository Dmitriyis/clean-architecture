package com.course.cleanarchitecture.domain.pet.application.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetSearchParamsDto {

    private String name;

    private Integer age;

    private String city;
}
