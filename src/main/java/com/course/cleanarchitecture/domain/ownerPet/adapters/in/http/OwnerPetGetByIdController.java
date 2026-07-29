package com.course.cleanarchitecture.domain.ownerPet.adapters.in.http;

import com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.dto.GetOwnerPetByIdResponse;
import com.course.cleanarchitecture.domain.ownerPet.adapters.in.http.mapper.OwnerPetMapperApi;
import com.course.cleanarchitecture.domain.ownerPet.core.application.queries.GetOwnerPetByIdQuery;
import com.course.cleanarchitecture.domain.ownerPet.core.application.queries.GetOwnerPetByIdQueryHandler;
import com.course.cleanarchitecture.domain.ownerPet.core.application.queries.GetOwnerPetByIdResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(OwnerPetConstantsHttp.ROOT_URL)
public class OwnerPetGetByIdController {

    private final OwnerPetMapperApi ownerPetMapperApi;
    private final GetOwnerPetByIdQueryHandler getOwnerPetByIdQueryHandler;

    @GetMapping("/{id}")
    public GetOwnerPetByIdResponse getOwnerPet(@PathVariable("id") UUID id) {
        GetOwnerPetByIdQuery query = new GetOwnerPetByIdQuery(id);

        GetOwnerPetByIdResult result = getOwnerPetByIdQueryHandler.execute(query);

        return ownerPetMapperApi.toGetOwnerPetByIdResponse(result);
    }
}
