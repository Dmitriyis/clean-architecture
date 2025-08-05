package com.course.cleanarchitecture.entity.doctor.useCase.useCaseImpl;

import com.course.cleanarchitecture.entity.doctor.useCase.DeleteDoctorByIdUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.DeleteDoctorByIdProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteDoctorByIdImpl implements DeleteDoctorByIdUseCase {

    private final DeleteDoctorByIdProvider deleteDoctorByIdProvider;

    @Override
    public UUID execute(UUID id) {
        return deleteDoctorByIdProvider.execute(id);
    }
}
