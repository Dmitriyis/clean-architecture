package com.course.cleanarchitecture.domain.reception.adapters.out.postgres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ReceptionEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @JoinColumn(name = "doctor_id")
    private UUID doctorId;

    @JoinColumn(name = "pet_id")
    private UUID petId;

    @Column(name = "analyses", columnDefinition = "text[]")
    @Type(ListArrayType.class)
    private List<String> analyses;

    @Column(name = "description")
    private String description;

    @Column(name = "start_reception")
    private LocalDateTime startReception;

    @Column(name = "end_reception")
    private LocalDateTime endReception;
}
