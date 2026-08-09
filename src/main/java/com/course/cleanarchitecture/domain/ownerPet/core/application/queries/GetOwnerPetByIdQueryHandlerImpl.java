package com.course.cleanarchitecture.domain.ownerPet.core.application.queries;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.domain.ownerPet.core.application.OwnerPetMapper;
import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import com.course.cleanarchitecture.domain.ownerPet.exceptions.OwnerPetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetOwnerPetByIdQueryHandlerImpl implements GetOwnerPetByIdQueryHandler {

    private final OwnerPetMapper ownerPetMapper;
    private final OwnerPetRepository ownerPetRepository;

    @Override
    public GetOwnerPetByIdResult execute(GetOwnerPetByIdQuery query) {
        OwnerPet ownerPet = ownerPetRepository.findById(query.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("OwnerPet", "id", query.getId().toString());

                    return new OwnerPetNotFoundException(message);
                });

        return ownerPetMapper.toGetOwnerPetByIdResult(ownerPet);
    }
}
