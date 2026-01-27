package com.course.cleanarchitecture.domain.doctor.adapters.out.postgres;

import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import com.course.cleanarchitecture.domain.doctor.core.ports.DoctorRepository;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DoctorRepositoryImpl implements DoctorRepository {

    private final DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public UUID save(Doctor doctor) {
        DoctorEntity doctorEntity = DoctorToDoctorEntityMapper.doctorToDoctorEntity(doctor);
        return doctorRepositoryJpa.save(doctorEntity).getId();
    }

    @Override
    public Doctor findById(UUID id) {
        DoctorEntity doctorEntity = doctorRepositoryJpa.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found Doctor by id: " + id + "."));

        List<UUID> receptionsId = new ArrayList<>();
        if (doctorEntity.getReceptions() != null) {
            receptionsId = doctorEntity.getReceptions()
                    .stream().map(ReceptionEntity::getId)
                    .collect(Collectors.toList());
        }

        Doctor doctor = new Doctor(doctorEntity.getId(), doctorEntity.getName(), doctorEntity.getProfession(), doctorEntity.getWorkExperience(), receptionsId);
        return doctor;
    }
}
