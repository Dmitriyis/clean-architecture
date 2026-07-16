package com.course.cleanarchitecture.domain.reception.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.domain.reception.core.model.events.ReceptionCreateDomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Reception extends Aggregate<UUID> {

    private UUID petId;

    private UUID doctorId;

    private List<String> analysesDirection;

    private String description;

    private LocalDateTime startReception;

    private LocalDateTime endReception;

    private Reception() {
    }

    private Reception(UUID id, UUID petId, UUID doctorId, List<String> analysesDirection, String description, LocalDateTime startReception, LocalDateTime endReception) {
        super(id);
        this.petId = petId;
        this.doctorId = doctorId;
        this.analysesDirection = analysesDirection;
        this.description = description;
        this.startReception = startReception;
        this.endReception = endReception;
        raiseDomainEvent(new ReceptionCreateDomainEvent(this));
    }

    public static Reception create(UUID id, UUID petId, UUID doctorId, List<String> analysesDirection, String description, LocalDateTime startReception, LocalDateTime endReception) {
        ValidationValueUtils.againstNull(id, "id,");
        ValidationValueUtils.againstNull(petId, "petId,");
        ValidationValueUtils.againstNull(analysesDirection, "analysesDirection,");
        ValidationValueUtils.againstNull(startReception, "startReception,");
        ValidationValueUtils.againstNull(endReception, "endReception,");

        ValidationValueUtils.againstNullOrEmpty(analysesDirection, "analysesDirection,");
        ValidationValueUtils.againstNullOrEmpty(description, "conclusions,");

        ValidationValueUtils.againstDateTimeGreaterOrEqualCurrent(startReception, "startReception,");
        ValidationValueUtils.againstDateTimeGreaterOrEqualCurrent(endReception, "endReception,");

        return new Reception(id, petId, doctorId, analysesDirection, description, startReception, endReception);
    }

    public static Reception reStore(UUID id, UUID petId, UUID doctorId, List<String> analyses, String description, LocalDateTime startReception, LocalDateTime endReception) {
        return new Reception(id, petId, doctorId, analyses, description, startReception, endReception);
    }
}
