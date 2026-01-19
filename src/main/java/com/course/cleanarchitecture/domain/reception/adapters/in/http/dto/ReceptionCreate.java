package com.course.cleanarchitecture.domain.reception.adapters.in.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ReceptionCreate {

    private UUID medicalCardId;

    private UUID doctorId;

    private List<String> analyses;

    private String conclusions;

    private LocalDateTime startReception;

    private LocalDateTime endReception;
}




