package com.course.cleanarchitecture.domain.doctor.presentation;

import com.course.cleanarchitecture.domain.doctor.application.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.domain.doctor.application.useCase.dto.DoctorUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
public class DoctorRestController {

    @GetMapping("/{id}")
    public DoctorRequestDto getDoctor(@PathVariable("id") UUID id) {
        return null;
    }

    @PostMapping
    public DoctorRestController saveDoctor(DoctorRequestDto doctorRequestDto) {
        return null;
    }

    @PutMapping
    public UUID updateDoctor(DoctorUpdateDto doctorUpdateDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public UUID deleteDoctor(@PathVariable("id") UUID id) {
        return null;
    }
}
