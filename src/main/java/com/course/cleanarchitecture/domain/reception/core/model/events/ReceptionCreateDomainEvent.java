package com.course.cleanarchitecture.domain.reception.core.model.events;


import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.DomainEvent;
import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
public class ReceptionCreateDomainEvent extends DomainEvent {
    private String medicalCardId;
    private String receptionId;

    public ReceptionCreateDomainEvent(Reception reception) {
        super(reception);

        ValidationValueUtils.againstNull(reception.getMedicalCardId(), "medicalCardId");
        ValidationValueUtils.againstNull(reception.getEndReception(), "receptionId");

        this.medicalCardId = reception.getMedicalCardId().toString();
        this.receptionId = reception.getId().toString();
    }
}
