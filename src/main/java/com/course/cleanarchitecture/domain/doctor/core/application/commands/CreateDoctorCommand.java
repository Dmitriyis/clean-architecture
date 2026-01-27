package com.course.cleanarchitecture.domain.doctor.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.domain.doctor.core.model.TypeProfession;
import lombok.Getter;

@Getter
public class CreateDoctorCommand {

    private String name;

    private TypeProfession profession;

    private Integer workExperience;

    private CreateDoctorCommand() {

    }

    public CreateDoctorCommand(String name, TypeProfession profession, Integer workExperience) {
        ValidationValueUtils.againstNull(name, "name");
        ValidationValueUtils.againstNull(profession, "profession");
        ValidationValueUtils.againstNull(workExperience, "workExperience");

        this.name = name;
        this.profession = profession;
        this.workExperience = workExperience;
    }
}
