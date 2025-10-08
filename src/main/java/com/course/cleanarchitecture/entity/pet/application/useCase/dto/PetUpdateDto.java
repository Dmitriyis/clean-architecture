package com.course.cleanarchitecture.entity.pet.application.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetUpdateDto {

    private UUID id;

    private String name;

    private Double weight;

    private Integer age;

    private UUID ownerId;
}
