package com.course.cleanarchitecture.domain.doctor.adapters.in.http.api;

import com.course.cleanarchitecture.domain.doctor.adapters.in.http.DoctorConstantsHttp;
import com.course.cleanarchitecture.domain.doctor.adapters.in.http.dto.DoctorCreate;
import com.course.cleanarchitecture.domain.doctor.core.application.commands.CreateDoctorCommand;
import com.course.cleanarchitecture.domain.doctor.core.application.commands.CreateDoctorCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(DoctorConstantsHttp.ROOT_URL)
public class DoctorCreateRestController {

    private final CreateDoctorCommandHandler createDoctorCommandHandler;

    @PostMapping
    public UUID createDoctor(@RequestBody DoctorCreate doctorCreate) {
        CreateDoctorCommand command = new CreateDoctorCommand(
                doctorCreate.name(),
                doctorCreate.profession(),
                doctorCreate.workExperience()
        );

        return createDoctorCommandHandler.execute(command);
    }
}
