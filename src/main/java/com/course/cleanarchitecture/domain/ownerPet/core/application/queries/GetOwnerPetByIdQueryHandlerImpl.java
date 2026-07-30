package com.course.cleanarchitecture.domain.ownerPet.core.application.queries;

import com.course.cleanarchitecture.domain.ownerPet.core.application.OwnerPetMapper;
import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetOwnerPetByIdQueryHandlerImpl implements GetOwnerPetByIdQueryHandler {

    private final OwnerPetMapper ownerPetMapper;
    private final OwnerPetRepository ownerPetRepository;

    @Override
    public Optional<GetOwnerPetByIdResult> execute(GetOwnerPetByIdQuery query) {
        Optional<OwnerPet> ownerPetOptional = ownerPetRepository.findById(query.getId());

        if (ownerPetOptional.isPresent()) {
            OwnerPet ownerPet = ownerPetOptional.get();

            return ownerPetMapper.toGetOwnerPetByIdResult(ownerPet);
        } else {
            return Optional.empty();
        }
    }
}
