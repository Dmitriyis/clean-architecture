package com.course.cleanarchitecture.entity.doctor.application.useCase.dto;

import com.course.cleanarchitecture.entity.appointment.application.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private List<AppointmentResponseDto> appointments;
}
