package com.course.cleanarchitecture.entity.doctor.presentation;

import com.course.cleanarchitecture.entity.doctor.useCase.CreateNewDoctorUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.DeleteDoctorByIdUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.FindAllDoctorBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.GetDoctorByIdUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.UpdateDoctorUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
public class DoctorRestController {

    private final UpdateDoctorUseCase updateDoctorUseCase;
    private final GetDoctorByIdUseCase getDoctorByIdUseCase;
    private final CreateNewDoctorUseCase createNewDoctorUseCase;
    private final DeleteDoctorByIdUseCase deleteDoctorByIdUseCase;
    private final FindAllDoctorBySearchParamsUseCase findAllDoctorBySearchParamsUseCase;

    @GetMapping("/{id}")
    public DoctorResponseDto getDoctor(@PathVariable("id") UUID id) {
        return getDoctorByIdUseCase.execute(id);
    }

    @PostMapping
    public UUID saveDoctor(@RequestBody DoctorRequestDto doctorRequestDto) {
        return createNewDoctorUseCase.execute(doctorRequestDto);
    }

    @PutMapping
    public UUID updateDoctor(@RequestBody DoctorUpdateDto doctorUpdateDto) {
        return updateDoctorUseCase.execute(doctorUpdateDto);
    }

    @DeleteMapping("/{id}")
    public UUID deleteDoctor(@PathVariable("id") UUID id) {
        return deleteDoctorByIdUseCase.execute(id);
    }
}
