package com.course.cleanarchitecture.domain.pet.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.domain.shared.Age;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Pet extends Aggregate<UUID> {

    private Age age;

    private String name;

    private Integer weight;

    private UUID ownerPetId;

    private MedicalCard medicalCard;

    private LocalDate registrationDate;

    private Pet() {
    }

    public Pet(UUID id, Age age, String name, Integer weight, UUID ownerPetId, MedicalCard medicalCard, LocalDate registrationDate) {
        ValidationValueUtils.againstNull(id, "id");
        ValidationValueUtils.againstNullOrEmpty(name, "name");
        ValidationValueUtils.againstNull(weight, "weight");
        ValidationValueUtils.againstNegative(weight, "weight");
        ValidationValueUtils.againstNull(ownerPetId, "ownerPetId");
        ValidationValueUtils.againstNull(medicalCard, "medicalCard");
        ValidationValueUtils.againstNull(registrationDate, "registrationDate");
        ValidationValueUtils.againstDateGreaterOrEqualCurrent(registrationDate, "registrationDate");

        this.id = id;
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.ownerPetId = ownerPetId;
        this.medicalCard = medicalCard;
        this.registrationDate = registrationDate;
    }

    public static Pet reStore(UUID id, Age age, String name, Integer weight, UUID ownerPetId, MedicalCard medicalCard, LocalDate registrationDate) {
        return new Pet(id, age, name, weight, ownerPetId, medicalCard, registrationDate);
    }
}
