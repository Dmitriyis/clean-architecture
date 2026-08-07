package com.course.cleanarchitecture.domain.reception.adapters.out.integration;

import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import com.course.cleanarchitecture.domain.reception.core.ports.DoctorCheckerForReception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorCheckerForReceptionImpl implements DoctorCheckerForReception {

    private final DoctorRepository doctorRepository;

    @Override
    public boolean isDoctorExists(UUID doctorId) {
        return doctorRepository.existsById(doctorId);
    }
}
