package com.course.cleanarchitecture.entity.ownerPet.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPetSearchParamsDto {

    private String name;

    private Integer age;

    private String city;
}
