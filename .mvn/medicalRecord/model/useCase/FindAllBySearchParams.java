package com.course.cleanarchitecture.entity.medicalRecord.model.useCase;

import com.course.cleanarchitecture.entity.medicalRecord.model.PetEntity;

import java.util.List;

public interface FindAllBySearchParams {
    List<PetEntity> findAllBySearchParams(String name, Integer age, String city);
    List<PetEntity> findAllBySearchParams(String name, String city);
}
