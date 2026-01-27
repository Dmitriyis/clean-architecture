package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.ownerPet.adapters.out.postgres.OwnerPetEntity;
import com.course.cleanarchitecture.domain.pet.core.model.Pet;
import org.springframework.stereotype.Service;

import static com.course.cleanarchitecture.domain.pet.adapters.out.postgres.MedicalCardEntityToMedicalCardMapper.medicalCardToMedicalCardEntity;

@Service
public class PetEntityToPetMapper {

    public static PetEntity petToPetEntity(Pet pet) {
        MedicalCardEntity medicalCardEntity = medicalCardToMedicalCardEntity(pet.getMedicalCard());

        OwnerPetEntity ownerPetEntity = OwnerPetEntity
                .builder()
                .id(pet.getOwnerPetId())
                .build();

        PetEntity petEntity = PetEntity
                .builder()
                .id(pet.getId())
                .name(pet.getName())
                .weight(pet.getWeight())
                .age(pet.getAge().getVolume())
                .ownerPet(ownerPetEntity)
                .medicalCard(medicalCardEntity)
                .registrationDate(pet.getRegistrationDate())
                .build();

        return petEntity;
    }
}
