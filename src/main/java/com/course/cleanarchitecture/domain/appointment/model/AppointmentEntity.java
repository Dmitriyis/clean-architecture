package com.course.cleanarchitecture.domain.appointment.model;

import com.course.cleanarchitecture.domain.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
@ToString(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class AppointmentEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

//    @ManyToMany
//    @JoinTable(
//            name = "appointment___analysis",
//            joinColumns = @JoinColumn(name = "appointment_id"),
//            inverseJoinColumns = @JoinColumn(name = "analysis_id")
//    )
//    private List<AnalysisEntity> analysis = new ArrayList<>();

    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;
}
