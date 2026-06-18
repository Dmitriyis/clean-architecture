package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.analysis.adapters.out.postgres.AnalysisEntity;
import com.course.cleanarchitecture.domain.shared.Age;
import com.course.cleanarchitecture.domain.pet.core.model.MedicalCard;
import com.course.cleanarchitecture.domain.pet.core.model.Pet;
import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.course.cleanarchitecture.domain.pet.adapters.out.postgres.PetEntityToPetMapper.petToPetEntity;

@Repository
@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository {

    private final PetRepositoryJpa petRepositoryJpa;

    @Override
    public UUID save(Pet pet) {
        PetEntity petEntity = PetEntityToPetMapper.petToPetEntity(pet);
        return petRepositoryJpa.save(petEntity).getId();
    }

    @Override
    public Pet findByMedicalCardId(UUID id) {
        PetEntity pet = petRepositoryJpa.findByMedicalCardId(id);
        MedicalCardEntity medicalCardEntity = pet.getMedicalCard();

        List<UUID> receptionsId = new ArrayList<>();
        if (medicalCardEntity.getReception() != null) {
            receptionsId = medicalCardEntity.getReception()
                    .stream()
                    .map(ReceptionEntity::getId)
                    .collect(Collectors.toList());
        }

        List<UUID> analysesId = new ArrayList<>();
        if (medicalCardEntity.getReception() != null) {
            analysesId = medicalCardEntity.getAnalysis()
                    .stream()
                    .map(AnalysisEntity::getId)
                    .collect(Collectors.toList());
        }

        MedicalCard medicalCard = MedicalCard.reStore(medicalCardEntity.getId(), medicalCardEntity.getUpdateTime(), receptionsId, analysesId);

        Age age = new Age(pet.getAge());

        Pet petReStore = Pet.reStore(pet.getId(), age, pet.getName(), pet.getWeight(), pet.getOwnerPet().getId(), medicalCard, pet.getRegistrationDate());
        return petReStore;
    }

    @Override
    public boolean existsPetByMedicalCardId(UUID medicalCardId) {
        return false;
    }

    @Override
    public void update(Pet pet) {
        PetEntity petEntity = petToPetEntity(pet);
        petRepositoryJpa.save(petEntity);
    }
}
//PetRepositoryImpl.java
//        Маппинг из JPA в домен — прямо в репозитории
//        В методе findByMedicalCardId() — 20 строк ручного маппинга. Это логика маппера, а не репозитория.
//        Репозиторий должен делегировать маппинг отдельному классу PetMapper.
//        Сейчас репозиторий знает и о структуре JPA-сущностей, и о доменных конструкторах — нарушение Single Responsibility.