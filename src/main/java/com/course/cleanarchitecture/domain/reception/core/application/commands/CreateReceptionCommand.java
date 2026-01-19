package com.course.cleanarchitecture.domain.reception.core.application.commands;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class CreateReceptionCommand {

    private UUID medicalCardId;

    private UUID doctorId;

    private List<String> analyses;

    private String conclusions;

    private LocalDateTime startReception;

    private LocalDateTime endReception;

    private CreateReceptionCommand() {

    }

    public CreateReceptionCommand(UUID medicalCardId, UUID doctorId, List<String> analyses, String conclusions, LocalDateTime startReception, LocalDateTime endReception) {
        ///
        this.medicalCardId = medicalCardId;
        this.doctorId = doctorId;
        this.analyses = analyses;
        this.conclusions = conclusions;
        this.startReception = startReception;
        this.endReception = endReception;
    }
}
