package com.course.cleanarchitecture.entity.ownerPet.presentation;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.useCase.CreateNewOwnerPetUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.DeleteOwnerPetByIdUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.FindAllOwnerPetBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.GetOwnerPetByIdUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.UpdateOwnerPetUseCase;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetUpdateDto;
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
@RequestMapping("/api/v1/owner-pet")
public class OwnerPetRestController {

    private final UpdateOwnerPetUseCase updateOwnerPetUseCase;
    private final GetOwnerPetByIdUseCase getOwnerPetByIdUseCase;
    private final CreateNewOwnerPetUseCase createNewOwnerPetUseCase;
    private final DeleteOwnerPetByIdUseCase deleteOwnerPetByIdUseCase;
    private final FindAllOwnerPetBySearchParamsUseCase findAllOwnerPetBySearchParamsUseCase;

    @PostMapping
    public UUID savePet(@RequestBody OwnerPetRequestDto ownerPetRequestDto) {
        return createNewOwnerPetUseCase.execute(ownerPetRequestDto);
    }

    @PutMapping
    public UUID updatePet(@RequestBody OwnerPetUpdateDto ownerPetUpdateDto) {
        return updateOwnerPetUseCase.execute(ownerPetUpdateDto);
    }

    @DeleteMapping("/{id}")
    public UUID updatePet(@PathVariable(name = "id") UUID petId) {
        return deleteOwnerPetByIdUseCase.execute(petId);
    }

    @GetMapping("/{id}")
    public OwnerPetEntity getPetEntityById(@PathVariable(name = "id") UUID id) {
        return getOwnerPetByIdUseCase.execute(id);
    }
}
