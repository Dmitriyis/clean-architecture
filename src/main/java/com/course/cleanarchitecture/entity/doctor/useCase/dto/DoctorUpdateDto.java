package com.course.cleanarchitecture.entity.doctor.useCase.dto;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorUpdateDto {
    private UUID id;

    private String name;

    private TypeProfession profession;

    private Integer workExperience;
}
