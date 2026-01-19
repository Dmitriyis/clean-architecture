package com.course.cleanarchitecture.domain.reception.adapters.out.postgres;

import com.course.cleanarchitecture.common.hibernate.converter.ListToArrayConverter;
import com.course.cleanarchitecture.domain.doctor.adapters.out.DoctorEntity;
import com.course.cleanarchitecture.domain.pet.adapters.out.postgres.MedicalCardEntity;
import com.course.cleanarchitecture.domain.pet.adapters.out.postgres.PetEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reception")
@ToString(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ReceptionEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "medical_card_id")
    private MedicalCardEntity medicalCard;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @Column(name = "analyses", columnDefinition = "text[]")
    @Type(ListArrayType.class)
    private List<String> analyses;

    @Column(name = "conclusions")
    private String conclusions;

    @Column(name = "start_reception")
    private LocalDateTime startReception;

    @Column(name = "end_reception")
    private LocalDateTime endReception;
}
