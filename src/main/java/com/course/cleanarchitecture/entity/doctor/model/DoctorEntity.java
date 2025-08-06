package com.course.cleanarchitecture.entity.doctor.model;

import com.course.cleanarchitecture.entity.appointment.model.AppointmentEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
@ToString(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class DoctorEntity {

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

    public void updateName(String name) {
        GenerateDoctorEntity.validateName(name);
        this.name = name;
    }

    public void updateProfession(TypeProfession profession) {
        this.profession = profession;
    }

    public void updateWorkExperience(Integer workExperience) {
        GenerateDoctorEntity.validateWorkExperience(workExperience);
        this.workExperience = workExperience;
    }
}
