package com.course.cleanarchitecture.domain.doctor.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.Aggregate;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Doctor extends Aggregate<UUID> {

    private String name;

    private TypeProfession profession;

    private Integer workExperience;

    private List<UUID> receptions = new ArrayList<>();

    private Doctor() {
    }

    public Doctor(UUID id ,String name, TypeProfession profession, Integer workExperience, List<UUID> receptions) {
        super(id);

        ValidationValueUtils.againstNull(id, "id");
        ValidationValueUtils.againstNull(name, "name");
        ValidationValueUtils.againstNull(profession, "profession");
        ValidationValueUtils.againstNull(workExperience, "workExperience");

        this.name = name;
        this.profession = profession;
        this.workExperience = workExperience;
        this.receptions = receptions;
    }

    public void addReception(UUID receptionId) {
        ValidationValueUtils.againstNull(receptionId, "receptionId");
        receptions.add(receptionId);
    }

    public static Doctor reStore(UUID id, String name, TypeProfession profession, Integer workExperience, List<UUID> receptions) {
        return new Doctor(id, name, profession, workExperience, receptions);
    }
}
