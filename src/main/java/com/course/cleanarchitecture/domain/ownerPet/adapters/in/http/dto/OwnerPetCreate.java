package com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.dto;

import com.course.cleanarchitecture.domain.ownerPet.core.model.valueObject.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OwnerPetCreate {
    private String phone;

    private String name;

    private Address address;
}
