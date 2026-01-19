package com.course.cleanarchitecture.domain.reception.core.application.queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllReceptionByPetIdQueryHandlerImpl implements GetAllReceptionByPetIdQueryHandler {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<GetAllReceptionByPetIdResponse> execute(GetAllReceptionByPetIdQueryCommand getAllReceptionByPetIdQueryCommand) {
        entityManager.createNativeQuery("select * from reception r where r.pet_id = :petId").getResultList();

        return null;
    }
}
