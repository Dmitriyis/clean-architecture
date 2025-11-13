package com.course.cleanarchitecture.domain.ownerPet.application.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPetRequestDto {

    private String name;

    private LocalDate registrationDate;

    private String city;

    private String street;

    private String numberHouse;
}
