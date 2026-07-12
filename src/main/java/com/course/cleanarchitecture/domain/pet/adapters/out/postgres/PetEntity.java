package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
public class PetEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "age")
    private Integer age;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @JoinColumn(name = "owner_id")
    private UUID ownerId;

    @OneToOne(mappedBy = "pet")
    @JoinColumn(name = "medical_card_id")
    private MedicalCardEntity medicalCard;
}
