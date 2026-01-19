package com.course.cleanarchitecture.domain.pet.adapters.in.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class PetCreate {

    private Integer age;

    private String name;

    private Double weight;

    private UUID ownerPetId;
}
