package com.course.cleanarchitecture.domain.reception.adapters.in.http;

import com.course.cleanarchitecture.domain.reception.adapters.in.http.dto.ReceptionCreate;
import com.course.cleanarchitecture.domain.reception.core.application.commands.CreateReceptionCommand;
import com.course.cleanarchitecture.domain.reception.core.application.commands.CreateReceptionCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reception")
public class ReceptionRestController {

    private final CreateReceptionCommandHandler createReceptionCommandHandler;

    @PostMapping
    public UUID createReception(@RequestBody ReceptionCreate receptionCreate) {
        CreateReceptionCommand createReceptionCommand = new CreateReceptionCommand(receptionCreate.getMedicalCardId(), receptionCreate.getDoctorId(), receptionCreate.getAnalyses(), receptionCreate.getConclusions(), receptionCreate.getStartReception(), receptionCreate.getEndReception());

        return createReceptionCommandHandler.execute(createReceptionCommand);
    }
}
