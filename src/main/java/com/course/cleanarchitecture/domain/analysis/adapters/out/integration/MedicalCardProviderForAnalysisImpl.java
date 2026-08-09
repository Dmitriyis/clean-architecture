package com.course.cleanarchitecture.domain.analysis.adapters.out.integration;

import com.course.cleanarchitecture.domain.analysis.core.ports.MedicalCardProviderForAnalysis;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MedicalCardProviderForAnalysisImpl implements MedicalCardProviderForAnalysis {

    private final PetRepository petRepository;

    @Override
    public boolean isMedicalCardExists(UUID medicalCardId) {
        return petRepository.existsPetByMedicalCardId(medicalCardId);
    }
}
