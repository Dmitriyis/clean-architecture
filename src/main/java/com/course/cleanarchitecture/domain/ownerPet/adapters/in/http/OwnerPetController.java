package com.course.cleanarchitecture.domain.ownerPet.adapters.in.http;

import com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.dto.OwnerPetDtoCreate;
import com.course.cleanarchitecture.domain.ownerPet.core.application.commands.CreateOwnerPetCommand;
import com.course.cleanarchitecture.domain.ownerPet.core.application.commands.CreateOwnerPetCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping(OwnerPetConstantsHttp.ROOT_URL)
public class OwnerPetController {

    private final CreateOwnerPetCommandHandler createOwnerPetCommandHandler;

    @PostMapping
    public UUID createOwnerPet(@RequestBody OwnerPetDtoCreate ownerPetCreate) {
        CreateOwnerPetCommand command = new CreateOwnerPetCommand(
                ownerPetCreate.phone(),
                ownerPetCreate.name(),
                ownerPetCreate.address().city(),
                ownerPetCreate.address().street(),
                ownerPetCreate.address().numberHouse()
        );

        return createOwnerPetCommandHandler.execute(command);
    }

//    @GetMapping("/{id}")
//    public Doctor getOwnerPet(@PathVariable("id") UUID id) throws NoSuchFieldException {
//        GetDoctorByIdCommand getDoctorByIdCommand = new GetDoctorByIdCommand(id);
//        return getDoctorByIdCommandHandler.execute(getDoctorByIdCommand);
//    }
//
//    @PutMapping("/{id}")
//    public Doctor updateOwnerPet(@PathVariable("id") UUID id) throws NoSuchFieldException {
//        GetDoctorByIdCommand getDoctorByIdCommand = new GetDoctorByIdCommand(id);
//        return getDoctorByIdCommandHandler.execute(getDoctorByIdCommand);
//    }
}
