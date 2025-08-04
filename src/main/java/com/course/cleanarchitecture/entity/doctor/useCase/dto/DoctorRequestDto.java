package com.course.cleanarchitecture.entity.doctor.useCase.dto;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.course.cleanarchitecture.entity.doctor.model.TypeProfession;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DoctorRequestDto {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "profession")
    private TypeProfession profession;

    @Column(name = "work_experience")
    private Integer workExperience;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentEntity> appointments = new ArrayList<>();
}
