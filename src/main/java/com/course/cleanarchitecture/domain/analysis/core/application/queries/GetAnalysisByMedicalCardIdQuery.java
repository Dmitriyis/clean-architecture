package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetAnalysisByMedicalCardIdQuery {
    private UUID medicalCardId;

    private GetAnalysisByMedicalCardIdQuery() {
    }

    public GetAnalysisByMedicalCardIdQuery(UUID medicalCardId) {
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");
        this.medicalCardId = medicalCardId;
    }
}
