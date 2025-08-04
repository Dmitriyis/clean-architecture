package com.course.cleanarchitecture.entity.doctor.useCase.dto;

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
public class DoctorUpdateDto {
    private UUID id;
    private LocalDateTime createDateTime;
}
