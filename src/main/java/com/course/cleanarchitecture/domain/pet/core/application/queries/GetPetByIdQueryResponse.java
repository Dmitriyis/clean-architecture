package com.course.cleanarchitecture.domain.pet.core.application.queries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPetByIdQueryResponse {

    private UUID id;

    private Integer age;

    private String name;

    private Double weight;

    private UUID ownerPetId;

    private LocalDate registrationDate;

    private MedicalCardGetPetByIdQueryResponse medicalCard;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MedicalCardGetPetByIdQueryResponse {
        private UUID id;

        private List<UUID> receptionsId;

        private LocalDateTime updateTime;

        private List<UUID> analyses;
    }
}

