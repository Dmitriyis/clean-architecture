package com.course.cleanarchitecture.domain.doctor.adapters.out.postgres;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionEntity;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DoctorRepositoryImpl implements DoctorRepository {

    private final DoctorJpaMapper  doctorJpaMapper;
    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public UUID save(Doctor doctor) {
        DoctorEntity doctorEntity = doctorJpaMapper.toDoctorEntity(doctor);
        return doctorRepositoryJpa.save(doctorEntity).getId();
    }

    @Override
    public Optional<Doctor> findById(UUID id) {
        Optional<DoctorEntity> doctorEntityOptional = doctorRepositoryJpa.findById(id);

        if (doctorEntityOptional.isEmpty()) {
            return Optional.empty();
        }

        DoctorEntity doctorEntity = doctorEntityOptional.get();

        Doctor doctor = doctorJpaMapper.toDoctor(doctorEntity);

        return Optional.of(doctor);
    }
}
