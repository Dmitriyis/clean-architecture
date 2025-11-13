package com.course.cleanarchitecture.domain.pet.application.useCase.mapper;

import com.course.cleanarchitecture.domain.pet.application.useCase.dto.PetRequestDto;
import com.course.cleanarchitecture.domain.pet.model.GeneratePetEntity;
import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import com.course.cleanarchitecture.domain.pet.application.useCase.dto.PetUpdateDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PetMapper{


    public PetEntity toPetEntity(PetRequestDto pet, UUID petId) {
        return GeneratePetEntity.generate(petId, pet.getName(), pet.getWeight(), pet.getAge(), pet.getRegistrationDate(), pet.getOwnerId(), null);
//        return GeneratePetEntity.generate(pet.getId(), pet.getName(), pet.getWeight(), pet.getAge(), pet.getRegistrationDate(), pet.getOwnerId(), null, null);
    }


    public PetEntity toPetEntity(PetUpdateDto pet, PetEntity petEntity) {
        UUID ownerIdActual = petEntity.getOwnerPet().getId();
        UUID ownerIdCandidate = pet.getOwnerId();

        Map<String, String> oldOwner = null;
        if(!ownerIdActual.equals(ownerIdCandidate)) {
            oldOwner = new HashMap<>();

            oldOwner.put(ownerIdActual.toString(), ownerIdCandidate.toString());
        }

        return GeneratePetEntity.generate(petEntity.getId(), pet.getName(), pet.getWeight(), pet.getAge(), petEntity.getRegistrationDate(), pet.getOwnerId(), oldOwner);
    }
}
