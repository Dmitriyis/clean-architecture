package com.course.cleanarchitecture.entity.doctor.useCase.dto;

import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDto {
    private UUID id;

    private String name;

    private TypeProfession profession;

    private Integer workExperience;

    @Builder.Default
    private List<AppointmentResponseDto> appointments = new ArrayList<>();
}
