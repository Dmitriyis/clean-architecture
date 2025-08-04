package com.course.cleanarchitecture.entity.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeService {
    CONSULTATION("Консультация"),
    TRANSPORTATION("Перевозка"),
    ANALYSIS("Анализ");

    private final String name;
}
