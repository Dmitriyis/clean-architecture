package com.course.cleanarchitecture.domain.analysis.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetAllAnalysisByMedicalCardIdCommand {
    private UUID medicalCardId;

    private GetAllAnalysisByMedicalCardIdCommand() {
    }

    public GetAllAnalysisByMedicalCardIdCommand(UUID medicalCardId) {
        ValidationValueUtils.againstNull(medicalCardId, "medicalCardId");
        this.medicalCardId = medicalCardId;
    }
}
