package com.course.cleanarchitecture.entity.medicalRecord.model;

import java.util.List;
import java.util.UUID;

public interface PetRepository {
    UUID save(PetEntity pet);

    List<PetEntity> findAllBySearchParams(String name, Integer age, String city);
    List<PetEntity> findAllBySearchParams(String name, String city);
}
