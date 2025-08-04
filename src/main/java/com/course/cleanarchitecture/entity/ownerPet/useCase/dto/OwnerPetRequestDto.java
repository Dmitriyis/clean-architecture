package com.course.cleanarchitecture.entity.ownerPet.useCase.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

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
