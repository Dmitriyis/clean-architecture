package com.course.cleanarchitecture.domain.pet.application.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetRequestDto {

    private String name;

    private Double weight;

    private Integer age;

    private LocalDate registrationDate;

    private UUID ownerId;
}
