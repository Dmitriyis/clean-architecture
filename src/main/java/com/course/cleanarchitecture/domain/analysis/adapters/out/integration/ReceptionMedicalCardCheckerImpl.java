package com.course.cleanarchitecture.domain.analysis.adapters.out.integration;

import com.course.cleanarchitecture.domain.analysis.core.ports.ReceptionMedicalCardChecker;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceptionMedicalCardCheckerImpl implements ReceptionMedicalCardChecker {

    private final PetRepository petRepository;

    @Override
    public boolean isMedicalCardExists(UUID medicalCardId) {
        return petRepository.existsPetByMedicalCardId(medicalCardId);
    }
}
