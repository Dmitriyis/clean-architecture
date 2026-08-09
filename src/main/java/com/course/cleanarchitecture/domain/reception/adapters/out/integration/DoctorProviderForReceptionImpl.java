package com.course.cleanarchitecture.domain.reception.adapters.out.integration;

import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import com.course.cleanarchitecture.domain.reception.core.ports.DoctorProviderForReception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DoctorProviderForReceptionImpl implements DoctorProviderForReception {

    private final DoctorRepository doctorRepository;

    @Override
    public boolean isDoctorExists(UUID doctorId) {
        return doctorRepository.existsById(doctorId);
    }
}
