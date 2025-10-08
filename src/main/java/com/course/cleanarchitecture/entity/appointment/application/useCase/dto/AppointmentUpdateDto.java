package com.course.cleanarchitecture.entity.appointment.application.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentUpdateDto {
    private UUID id;
    private LocalDateTime createDateTime;
}
