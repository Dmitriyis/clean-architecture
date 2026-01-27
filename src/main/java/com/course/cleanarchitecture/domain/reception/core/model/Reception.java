package com.course.cleanarchitecture.domain.reception.core.model;

import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.domain.reception.core.model.events.ReceptionCreateDomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Reception extends Aggregate<UUID> {

    private UUID medicalCardId;

    private UUID doctorId;

    private List<String> analyses;

    private String conclusions;

    private LocalDateTime startReception;

    private LocalDateTime endReception;

    private Reception() {
    }

    public Reception(UUID id, UUID medicalCardId, UUID doctorId, List<String> analyses, String conclusions, LocalDateTime startReception, LocalDateTime endReception) {
        super(id);
        this.medicalCardId = medicalCardId;
        this.doctorId = doctorId;
        this.analyses = analyses;
        this.conclusions = conclusions;
        this.startReception = startReception;
        this.endReception = endReception;
        raiseDomainEvent(new ReceptionCreateDomainEvent(this));
    }

    public static Reception reStore(UUID id, UUID medicalCardId, UUID doctorId, List<String> analyses, String conclusions, LocalDateTime startReception, LocalDateTime endReception) {
        return new Reception(id, medicalCardId, doctorId, analyses, conclusions, startReception, endReception);
    }
}
