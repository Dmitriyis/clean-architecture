package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.pet.core.model.MedicalCard;
import com.course.cleanarchitecture.domain.pet.core.model.Pet;
import com.course.cleanarchitecture.domain.shared.Age;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetJpaMapper {

    private final MedicalCardJpaMapper medicalCardJpaMapper;

    public PetEntity petToPetEntity(Pet pet) {
        MedicalCardEntity medicalCardEntity = medicalCardJpaMapper.toMedicalCardEntity(pet.getMedicalCard());

        PetEntity petEntity = PetEntity
                .builder()
                .id(pet.getId())
                .name(pet.getName())
                .weight(pet.getWeight())
                .age(pet.getAge().getVolume())
                .ownerId(pet.getOwnerPetId())
                .medicalCard(medicalCardEntity)
                .registrationDate(pet.getRegistrationDate())
                .build();

        medicalCardEntity.setPet(petEntity);

        return petEntity;
    }

    public Pet petTo(PetEntity petEntity) {
        MedicalCard medicalCard = medicalCardJpaMapper.toMedicalCard(petEntity.getMedicalCard());

        Age age = new Age(petEntity.getAge());

        Pet pet = Pet.reStore(
                petEntity.getId(),
                age,
                petEntity.getName(),
                petEntity.getWeight(),
                petEntity.getOwnerId(),
                medicalCard,
                petEntity.getRegistrationDate()
        );

        return pet;
    }
}
