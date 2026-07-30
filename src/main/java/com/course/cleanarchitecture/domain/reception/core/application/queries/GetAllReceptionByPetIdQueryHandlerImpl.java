package com.course.cleanarchitecture.domain.reception.core.application.queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllReceptionByPetIdQueryHandlerImpl implements GetAllReceptionByPetIdQueryHandler {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<GetAllReceptionByPetIdResponse> execute(GetAllReceptionByPetIdQuery query) {
        List<Object[]> resultsReception = entityManager.createNativeQuery("select * from reception r where r.pet_id = :petId").getResultList();

        return resultsReception.stream()
                .map(this::mapRowToResponse)
                .collect(Collectors.toList());
    }

    private GetAllReceptionByPetIdResponse mapRowToResponse(Object[] row) {
        UUID petId = (UUID) row[0];
        UUID doctorId = (UUID) row[1];
        String[] analysesArray = (String[]) row[2];
        List<String> analyses = analysesArray == null ? List.of() : Arrays.asList(analysesArray);
        String description = (String) row[3];
        LocalDateTime start = ((Timestamp) row[4]).toLocalDateTime();
        LocalDateTime end = ((Timestamp) row[5]).toLocalDateTime();
        return new GetAllReceptionByPetIdResponse(petId, doctorId, analyses, description, start, end);
    }
}
