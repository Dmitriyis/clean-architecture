package com.course.cleanarchitecture.domain.doctor.adapters.in.http.dto;

import com.course.cleanarchitecture.domain.doctor.core.model.TypeProfession;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DoctorCreate {

    private String name;

    private TypeProfession profession;

    private Integer workExperience;
}
