package com.course.cleanarchitecture.domain.ownerPet.core.application.queries;

import com.course.cleanarchitecture.domain.shared.Address;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record GetOwnerPetByIdResult(String name,
                                    String phone,
                                    LocalDate registrationDate,
                                    Address address,
                                    List<UUID> petsId) {
}
