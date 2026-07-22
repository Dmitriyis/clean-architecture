package com.course.cleanarchitecture.domain.doctor.adapters.in.http.dto;

import com.course.cleanarchitecture.domain.doctor.core.model.TypeProfession;

public record DoctorGetByIdResponse(String name,
                                    TypeProfession profession,
                                    Integer workExperience) {
}
