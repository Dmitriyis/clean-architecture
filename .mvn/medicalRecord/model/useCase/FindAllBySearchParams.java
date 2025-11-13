package com.course.cleanarchitecture.domain.medicalRecord.model.useCase;

import com.course.cleanarchitecture.domain.medicalRecord.model.PetEntity;

import java.util.List;

public interface FindAllBySearchParams {
    List<PetEntity> findAllBySearchParams(String name, Integer age, String city);
    List<PetEntity> findAllBySearchParams(String name, String city);
}
