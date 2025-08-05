package com.course.cleanarchitecture.entity.appointment.useCase.dto;


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
public class AppointmentRequestDto {
    private UUID petId;
    private UUID doctorId;
}
