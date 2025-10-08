package com.course.cleanarchitecture.entity.ownerPet.application.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPetUpdateDto {
    private UUID id;

    private String name;
    
    private String city;

    private String street;

    private String numberHouse;
}
