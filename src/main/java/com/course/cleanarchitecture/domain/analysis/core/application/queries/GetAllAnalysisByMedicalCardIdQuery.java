package com.course.cleanarchitecture.domain.analysis.core.application.queries;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetAllAnalysisByMedicalCardIdQuery {
    private UUID medicalCardId;

    private GetAllAnalysisByMedicalCardIdQuery() {
    }

    public GetAllAnalysisByMedicalCardIdQuery(UUID medicalCardId) {
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");
        this.medicalCardId = medicalCardId;
    }
}
