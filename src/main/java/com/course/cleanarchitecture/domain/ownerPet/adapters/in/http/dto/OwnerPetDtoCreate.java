package com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.dto;

public record OwnerPetDtoCreate(String phone,
                                String name,
                                AddressDto address) {

}
