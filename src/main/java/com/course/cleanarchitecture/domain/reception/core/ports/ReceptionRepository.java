package com.course.cleanarchitecture.domain.reception.core.ports;

import com.course.cleanarchitecture.domain.reception.core.model.Reception;

import java.util.List;
import java.util.UUID;

public interface ReceptionRepository {
    UUID save(Reception reception);

    List<Reception> findAllByPetId(UUID petId);
}
