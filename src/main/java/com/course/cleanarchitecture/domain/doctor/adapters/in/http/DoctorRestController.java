package com.course.cleanarchitecture.domain.doctor.adapters.in.http;

import com.course.cleanarchitecture.domain.doctor.adapters.in.http.dto.DoctorCreate;
import com.course.cleanarchitecture.domain.doctor.core.application.commands.CreateDoctorCommand;
import com.course.cleanarchitecture.domain.doctor.core.application.commands.CreateDoctorCommandHandler;
import com.course.cleanarchitecture.domain.doctor.core.application.commands.GetDoctorByIdCommand;
import com.course.cleanarchitecture.domain.doctor.core.application.commands.GetDoctorByIdCommandHandler;
import com.course.cleanarchitecture.domain.doctor.core.model.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/doctors")
public class DoctorRestController {

    private final CreateDoctorCommandHandler createDoctorCommandHandler;
    private final GetDoctorByIdCommandHandler getDoctorByIdCommandHandler;

    @PostMapping
    public UUID createDoctor(@RequestBody DoctorCreate doctorCreate) {
        CreateDoctorCommand createDoctorCommand = new CreateDoctorCommand(doctorCreate.getName(), doctorCreate.getProfession(), doctorCreate.getWorkExperience());

        return createDoctorCommandHandler.execute(createDoctorCommand);
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable("id") UUID id) throws NoSuchFieldException {
        GetDoctorByIdCommand getDoctorByIdCommand = new GetDoctorByIdCommand(id);
        return getDoctorByIdCommandHandler.execute(getDoctorByIdCommand);
    }
}
