package com.course.cleanarchitecture.entity.pet.presentation;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.useCase.CreateNewPetUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.DeletePetByIdUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.FindAllPetBySearchParamsUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.GetPetByIdUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.UpdatePetUseCase;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pet")
public class PetRestController {

    private final UpdatePetUseCase updatePetUseCase;
    private final GetPetByIdUseCase getPetByIdUseCase;
    private final CreateNewPetUseCase createNewPetUseCase;
    private final DeletePetByIdUseCase deletePetByIdUseCase;
    private final FindAllPetBySearchParamsUseCase findAllPetBySearchParamsUseCase;

    @PostMapping
    public UUID savePet(@RequestBody PetRequestDto petRequestDto) {
        return createNewPetUseCase.execute(petRequestDto);
    }

    @PutMapping
    public UUID updatePet(@RequestBody PetUpdateDto petUpdateDto) {
        return updatePetUseCase.execute(petUpdateDto);
    }

    @DeleteMapping("/{id}")
    public UUID updatePet(@PathVariable(name = "id") UUID petId) {
        return deletePetByIdUseCase.execute(petId);
    }

    @GetMapping("/{id}")
    public PetEntity getPetEntityById(@PathVariable(name = "id") UUID id) {
        return getPetByIdUseCase.execute(id);
    }

    @GetMapping("/{id}")
    public List<PetEntity> getPetEntityById(@RequestBody PetSearchParamsDto petSearchParamsDto) {
        return findAllPetBySearchParamsUseCase.execute(petSearchParamsDto);
    }
}
