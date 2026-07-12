package com.course.cleanarchitecture.domain.pet.adapters.in.http;

import com.course.cleanarchitecture.domain.pet.adapters.in.http.dto.PetCreate;
import com.course.cleanarchitecture.domain.pet.core.application.commands.CreatePetCommand;
import com.course.cleanarchitecture.domain.pet.core.application.commands.CreatePetCommandHandler;
import com.course.cleanarchitecture.domain.pet.core.application.queries.GetPetByIdQuery;
import com.course.cleanarchitecture.domain.pet.core.application.queries.GetPetByIdQueryHandler;
import com.course.cleanarchitecture.domain.pet.core.application.queries.GetPetByIdQueryResponse;
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
@RequestMapping(PetConstantsHttp.URL_ROOT)
public class PetRestController {

    private final CreatePetCommandHandler createPetCommandHandler;
    private final GetPetByIdQueryHandler getPetByIdQueryCommandHandler;

    @PostMapping
    public UUID createPet(@RequestBody PetCreate petCreate) {
        CreatePetCommand command = new CreatePetCommand(
                petCreate.age(),
                petCreate.name(),
                petCreate.weight(),
                petCreate.ownerPetId()
        );

        return createPetCommandHandler.execute(command);
    }

    @GetMapping("/{id}")
    public GetPetByIdQueryResponse getPet(@PathVariable(name = "id") UUID id) throws NoSuchFieldException {
        GetPetByIdQuery query = new GetPetByIdQuery(id);

        return getPetByIdQueryCommandHandler.execute(query);
    }
}
