package com.course.cleanarchitecture.domain.pet.adapters.in.http.dto;

import java.util.UUID;


public record PetCreate(Integer age, String name, Integer weight, UUID ownerPetId) {


}
