package com.course.cleanarchitecture.domain.appointment.application.useCase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDto {

    private UUID id;

    private UUID petId;

    private LocalDateTime createDateTime;
}
