package com.course.cleanarchitecture.domain.doctor.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeProfession {
    THERAPIST("Терапевт"),
    RADIOLOGIST("Рентгенолог"),
    REHABILITOLOGIST("Реабилитолог ");

    private final String name;
}
