package com.course.cleanarchitecture.domain.doctor.core.model;

import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.domain.reception.core.model.Reception;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Doctor extends Aggregate<UUID> {

    private String name;

    private TypeProfession profession;

    private Integer workExperience;

    private List<Reception> receptions = new ArrayList<>();
}
