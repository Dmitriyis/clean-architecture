package com.course.cleanarchitecture.domain.pet.adapters.in.http;

import com.course.cleanarchitecture.domain.pet.adapters.in.http.dto.PetCreate;
import com.course.cleanarchitecture.domain.pet.core.application.commands.CreatePetCommand;
import com.course.cleanarchitecture.domain.pet.core.application.commands.CreatePetCommandHandler;
import com.course.cleanarchitecture.domain.pet.core.application.queries.GetPetByIdQueryCommand;
import com.course.cleanarchitecture.domain.pet.core.application.queries.GetPetByIdQueryCommandHandler;
import com.course.cleanarchitecture.domain.pet.core.application.queries.GetPetByIdQueryResponse;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
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
@RequestMapping("api/v1/pet")
public class PetRestController {

    private final CreatePetCommandHandler createPetCommandHandler;
    private final GetPetByIdQueryCommandHandler getPetByIdQueryCommandHandler;

    private final PetRepository petRepository;
    @PostMapping
    public UUID createPet(@RequestBody PetCreate petCreate) {
        CreatePetCommand createPetCommand = new CreatePetCommand(petCreate.getAge(), petCreate.getName(), petCreate.getWeight(), petCreate.getOwnerPetId());

        return createPetCommandHandler.execute(createPetCommand);
    }

    @GetMapping("/{id}")
    public GetPetByIdQueryResponse getPet(@PathVariable(name = "id") UUID id) throws NoSuchFieldException {
        GetPetByIdQueryCommand getPetByIdQueryCommand = new GetPetByIdQueryCommand(id);

        return getPetByIdQueryCommandHandler.execute(getPetByIdQueryCommand);
    }
}
