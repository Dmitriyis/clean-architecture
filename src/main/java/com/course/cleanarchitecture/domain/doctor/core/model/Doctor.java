package com.course.cleanarchitecture.domain.doctor.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.Aggregate;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Doctor extends Aggregate<UUID> {

    private String name;

    private TypeProfession profession;

    private Integer workExperience;

    private Doctor() {
    }

    private Doctor(UUID id ,String name, TypeProfession profession, Integer workExperience) {
        super(id);
        this.name = name;
        this.profession = profession;
        this.workExperience = workExperience;
    }

    public static Doctor create(UUID id ,String name, TypeProfession profession, Integer workExperience) {
        ValidationValueUtils.againstNull(id, "id");
        ValidationValueUtils.againstNull(name, "name");
        ValidationValueUtils.againstNull(profession, "profession");
        ValidationValueUtils.againstNull(workExperience, "workExperience");
        ValidationValueUtils.againstNegative(workExperience, "workExperience");

        return new Doctor(id, name, profession, workExperience);
    }

    public static Doctor reStore(UUID id, String name, TypeProfession profession, Integer workExperience) {
        return new Doctor(id, name, profession, workExperience);
    }
}
