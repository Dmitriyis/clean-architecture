package com.course.cleanarchitecture.domain.doctor.core.application.queries;

import com.course.cleanarchitecture.domain.doctor.core.model.TypeProfession;

public record GetDoctorByIdResult(String name,
                                  TypeProfession profession,
                                  Integer workExperience) {
}