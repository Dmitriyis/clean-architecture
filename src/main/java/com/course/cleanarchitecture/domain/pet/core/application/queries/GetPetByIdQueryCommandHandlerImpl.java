package com.course.cleanarchitecture.domain.pet.core.application.queries;

import com.course.cleanarchitecture.domain.pet.core.application.queries.GetPetByIdQueryResponse.MedicalCardGetPetByIdQueryResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetPetByIdQueryCommandHandlerImpl implements GetPetByIdQueryCommandHandler {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public GetPetByIdQueryResponse execute(GetPetByIdQueryCommand getPetByIdQueryCommand) throws NoSuchFieldException {

        GetPetByIdQueryResponse getPetByIdQueryResponse = findPetById(getPetByIdQueryCommand.getId());

        MedicalCardGetPetByIdQueryResponse medicalCard = getPetByIdQueryResponse.getMedicalCard();

        List<UUID> analysesId = findAnalysisByMedicalCardId(medicalCard.getId());
        medicalCard.setAnalyses(analysesId);

        List<UUID> receptionsId = findReceptionByMedicalCardId(medicalCard.getId());
        medicalCard.setReceptionsId(receptionsId);


        return getPetByIdQueryResponse;
    }

    private GetPetByIdQueryResponse findPetById(UUID petId) throws NoSuchFieldException {
        Query querySqlPet = entityManager.createNativeQuery("select " +
                "pet.id, pet.name, pet.weight, pet.age, pet.registration_date, " +
                "med.id, med.update_time, " +
                "opet.id " +
                "from pet as pet " +
                "left join owner_pet as opet on opet.id = pet.owner_pet_id " +
                "left join medical_card as med on med.id = pet.medical_card_id " +
                "where pet.id = ?1");

        querySqlPet.setParameter(1, petId);

        List<Object[]> resultsPet = querySqlPet.getResultList();

        List<GetPetByIdQueryResponse> getPetByIdQueryResponses = resultsPet
                .stream()
                .map(row -> {
                    UUID id = (UUID) row[0];
                    String name = (String) row[1];
                    Integer weight = (Integer) row[2];
                    Integer age = (Integer) row[3];
                    LocalDate registrationDate = ((Timestamp) row[4]).toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();

                    LocalDateTime updateTime = ((Timestamp) row[6]).toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();
                    UUID medicalCardId = (UUID) row[5];
                    MedicalCardGetPetByIdQueryResponse medicalCard = MedicalCardGetPetByIdQueryResponse
                            .builder()
                            .id(medicalCardId)
                            .updateTime(updateTime)
                            .build();

                    UUID ownerPetId = (UUID) row[7];

                    return new GetPetByIdQueryResponse(id, age, name, weight, ownerPetId, registrationDate, medicalCard);
                })
                .toList();


        if (getPetByIdQueryResponses.isEmpty()) {
            throw new NoSuchFieldException("Not found Pet by id: " + petId + ".");
        }

        return getPetByIdQueryResponses.get(0);
    }

    private List<UUID> findReceptionByMedicalCardId(UUID medicalCardId) {
        Query queryReception = entityManager.createNativeQuery("select rec.id " +
                "from reception as rec " +
                "where rec.medical_card_id = ?1");

        queryReception.setParameter(1, medicalCardId);
        List<UUID> receptionsId = queryReception.getResultList();

        return receptionsId;
    }

    private List<UUID> findAnalysisByMedicalCardId(UUID medicalCardId) {
        Query queryAnalysis = entityManager.createNativeQuery("select a.medical_card_id " +
                "from analysis as a " +
                "where a.medical_card_id = ?1");
        queryAnalysis.setParameter(1, medicalCardId);
        List<UUID> analysesId = queryAnalysis.getResultList();

        return analysesId;
    }
}
