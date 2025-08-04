package com.course.cleanarchitecture.entity.transportOrder.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum Status {
    DONE("Готово"),
    CANCELLED("Отменен"),
    EXPECTATION("Ожидание"),
    ACCEPT("Принят");

    private final String statusName;
}

