package com.course.cleanarchitecture.entity.appointment.presentation;

import com.course.cleanarchitecture.entity.appointment.useCase.CreateNewAppointmentUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.DeleteAppointmentByIdUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.GetAppointmentByIdUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.UpdateAppointmentUseCase;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentRequestDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentUpdateDto;
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
@RequestMapping("/api/v1/appointments")
public class AppointmentRestController {

    private final UpdateAppointmentUseCase updateAppointmentUseCase;
    private final GetAppointmentByIdUseCase getAppointmentByIdUseCase;
    private final CreateNewAppointmentUseCase createNewAppointmentUseCase;
    private final DeleteAppointmentByIdUseCase deleteAppointmentByIdUseCase;

    @PostMapping
    public UUID saveAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        return createNewAppointmentUseCase.execute(appointmentRequestDto);
    }

    @PutMapping
    public UUID updateAppointment(@RequestBody AppointmentUpdateDto appointmentUpdateDto) {
        return updateAppointmentUseCase.execute(appointmentUpdateDto);
    }

    @DeleteMapping("/{id}")
    public UUID deleteAppointment(@PathVariable(name = "id") UUID id) {
        return deleteAppointmentByIdUseCase.execute(id);
    }

    @GetMapping("/{id}")
    public AppointmentResponseDto getAppointment(@PathVariable(name = "id") UUID id) {
        return getAppointmentByIdUseCase.execute(id);
    }
}
